package com.exeal.vault.javalibrary.health.infrastructure.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class HealthControllerShould {

  @Autowired private TestRestTemplate restTemplate;
  @LocalServerPort private int port;

  @Test
  public void return_200_when_application_is_up() {
    final var expectedResponse = new HealthResponse("OK");

    final var response =
        restTemplate.getForEntity("http://localhost:" + port + "/health", HealthResponse.class);

    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    Assertions.assertThat(response.getBody()).isEqualTo(expectedResponse);
  }
}
