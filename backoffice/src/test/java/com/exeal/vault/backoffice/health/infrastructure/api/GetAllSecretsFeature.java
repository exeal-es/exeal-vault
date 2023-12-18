package com.exeal.vault.backoffice.health.infrastructure.api;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GetAllSecretsFeature {

  private VaultApi api;
  private Redis redis;

  @BeforeEach
  void setUp() {
    api = new VaultApi();
    redis = new Redis();
  }

  @Test
  public void  getAllSecrets(){
    //Given
    //Dado que hay un secreto con la clave api_secret y el valor 123456
      redis.addSecret("api_secret", "123456");
    //when
    //Cuando se piden todos los secretos
      List<Secret> secrets = api.getAllSecrets();
    //Then
    //Se devuelve un secreto con la clave api_secret y el valor 123456
    Secret secret = new Secret("api_secret", "123456");
    Assertions.assertThat(secrets).contains(secret);
  }

}
