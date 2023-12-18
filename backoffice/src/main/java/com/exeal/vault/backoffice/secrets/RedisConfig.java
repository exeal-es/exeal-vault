package com.exeal.vault.backoffice.secrets;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

  @Bean
  public JedisConnectionFactory jedisConnectionFactory(final RedisProperties redisProperties) {
    final JedisClientConfiguration jedisClientConfiguration =
        JedisClientConfiguration.builder().usePooling().build();
    final RedisStandaloneConfiguration redisStandaloneConfiguration =
        new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
    return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
  }

  @Bean
  public RedisTemplate<String, Object> secretsAccessor(
      final JedisConnectionFactory jedisConnectionFactory) {

    final RedisTemplate<String, Object> secretsAccessor = new RedisTemplate<>();
    secretsAccessor.setConnectionFactory(jedisConnectionFactory);
    secretsAccessor.setDefaultSerializer(new StringRedisSerializer());
    secretsAccessor.setKeySerializer(new StringRedisSerializer());
    return secretsAccessor;
  }
}
