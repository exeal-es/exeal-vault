package com.exeal.vault.backoffice.secrets;

import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class VaultApi {
  private final RestTemplate httpClient;

  public VaultApi(int apiPort) {
    httpClient = new RestTemplateBuilder().rootUri("http://localhost:" + apiPort).build();
  }

  public List<Secret> getAllSecrets() {
    final ResponseEntity<List<Secret>> response =
        httpClient.exchange(
            "/secrets", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
    return response.getBody();
  }
}
