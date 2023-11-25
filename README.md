# exeal-vault
Secure, store, and tightly control access to your applications' secrets.

## Backoffice

### Run

```bash
./mvnw -pl backoffice spring-boot:run -Dspring-boot.run.jvmArguments="-DPORT=$PORT"
```

Note: Set the environment variable PORT to the port you want to use.

### Build

```bash
./mvnw -pl backoffice clean install && java -jar backoffice/target/vault-backoffice.jar -DPORT=$PORT
```

Note: Set the environment variable PORT to the port you want to use.
