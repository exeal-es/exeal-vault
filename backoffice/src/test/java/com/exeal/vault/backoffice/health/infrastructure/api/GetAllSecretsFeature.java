package com.exeal.vault.backoffice.health.infrastructure.api;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
public class GetAllSecretsFeature {
  @LocalServerPort
  private int apiPort;

  @Container
  private final static GenericContainer redisContainer =
      new GenericContainer(DockerImageName.parse("redis:5.0.3")).withExposedPorts(6379);

  private VaultApi api;
  private Redis redis;

  @DynamicPropertySource
  private static void registerRedisProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.redis.host", redisContainer::getHost);
    registry.add("spring.data.redis.port", () -> redisContainer.getFirstMappedPort().toString());
  }

  @BeforeEach
  void setUp() {
    api = new VaultApi(apiPort);
    redis = new Redis(redisContainer.getHost(), redisContainer.getFirstMappedPort());
  }

  @Test
  public void getAllSecrets() {
    redis.addSecret("api_secret", "123456");

    List<Secret> secrets = api.getAllSecrets();

    Secret secret = new Secret("api_secret", "123456");
    Assertions.assertThat(secrets).contains(secret);
  }
}
