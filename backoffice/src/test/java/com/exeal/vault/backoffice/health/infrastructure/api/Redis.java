package com.exeal.vault.backoffice.health.infrastructure.api;

import java.util.List;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.JedisPool;

public class Redis {
  private final JedisPool jedisPool;

  public Redis(final String host, final Integer port) {
    jedisPool = new JedisPool(host, port);
  }

  public void addSecret(String key, String value) {
    try (var jedis = jedisPool.getResource()) {
      jedis.hset("secrets", key, value);
    }
  }
}
