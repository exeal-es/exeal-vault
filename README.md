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

## Frontend

### Run

```bash
cd frontend && npm install && npm start
```

### Build

```bash
cd frontend && npm install && npm run build
```

## Run locally with docker-compose

```bash
docker compose --env-file .env.dev up
```

Test the backoffice on http://localhost:8080

```bash
curl http://localhost:8080/health
```

Test the java-library on http://localhost:8081

```bash
curl http://localhost:8081/health
```

## Build with docker-compose for any environment

Create the `.env` file as described in `.env.dev`

```bash
docker compose build
```
