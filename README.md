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
./mvnw -pl backoffice clean install && java -DPORT=$PORT -jar backoffice/target/vault-backoffice.jar
```

Note: Set the environment variable PORT to the port you want to use.

## Java Library

### Run

```bash
./mvnw -pl java-library spring-boot:run -Dspring-boot.run.jvmArguments="-DPORT=$PORT"
```

Note: Set the environment variable PORT to the port you want to use.

### Build

```bash
./mvnw -pl java-library clean install && java -DPORT=$PORT -jar
java-library/target/vault-java-library.jar
```

Note: Set the environment variable PORT to the port you want to use.
