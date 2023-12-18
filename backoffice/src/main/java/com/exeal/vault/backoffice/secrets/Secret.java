package com.exeal.vault.backoffice.secrets;

import java.util.Objects;

public class Secret implements java.io.Serializable {
  private final String key;
  private final String value;

  public Secret(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
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
    return Objects.equals(key, secret.key) && Objects.equals(value, secret.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    return "Secret{" + "key='" + key + '\'' + ", value='" + value + '\'' + '}';
  }
}
