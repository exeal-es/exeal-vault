package com.exeal.vault.backoffice.secrets;

import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class GetAllSecretsEndpoint {
  private final RedisTemplate<String, Object> redisTemplate;

  public GetAllSecretsEndpoint(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @GetMapping(value = "/secrets", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Secret>> getAllSecrets() {
    return ResponseEntity.ok(
        redisTemplate.opsForHash().entries("secrets").entrySet().stream()
            .map(entry -> new Secret(entry.getKey().toString(), (String) entry.getValue()))
            .toList());
  }
}
