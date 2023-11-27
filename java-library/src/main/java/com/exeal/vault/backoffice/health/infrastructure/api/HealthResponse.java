package com.exeal.vault.backoffice.health.infrastructure.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public final class HealthResponse {
  private final String status;

  @JsonCreator
  public HealthResponse(@JsonProperty("status") String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthResponse response = (HealthResponse) o;
    return Objects.equals(status, response.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }
}
