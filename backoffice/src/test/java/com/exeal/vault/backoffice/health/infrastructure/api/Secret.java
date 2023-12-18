package com.exeal.vault.backoffice.health.infrastructure.api;

import java.util.Objects;

public class Secret {

  String key;
  String value;

  public Secret(String key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Secret secret = (Secret) o;
    return Objects.equals(key, secret.key) && Objects.equals(value,
        secret.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }
}
