package com.exeal.vault.backoffice.secrets;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class GetAllSecretsEndpoint {
  private final RedisTemplate<String, Object> secretsAccessor;

  public GetAllSecretsEndpoint(RedisTemplate<String, Object> secretsAccessor) {
    this.secretsAccessor = secretsAccessor;
  }

  @GetMapping(value = "/secrets", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Secret>> getAllSecrets() {
    return ResponseEntity.ok(
        secretsAccessor.opsForHash().entries("secrets").entrySet().stream()
            .map(entry -> new Secret((String) entry.getKey(), (String) entry.getValue()))
            .collect(Collectors.toList()));
  }
}
