package com.exeal.vault.backoffice.secrets;

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
