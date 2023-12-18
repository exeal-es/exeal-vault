package com.exeal.vault.backoffice.secrets;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Secret {
  private final String key;
  private final String value;

  @JsonCreator
  public Secret(@JsonProperty("key") String key, @JsonProperty("value") String value) {
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
