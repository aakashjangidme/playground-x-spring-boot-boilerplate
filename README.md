## Spring Boot Java Boilerplate

This is a boilerplate Spring Boot app using Java.

## Running The App

Ensure you have Java 8 or later.

```
./mvnw clean package
target/playground-x-spring-boot-boilerplate-0.0.1-SNAPSHOT.jar
```

## Running The App Using Docker

Ensure you have a working Docker environment.

```
make dist image run
```

## Testing The Endpoints

Point your browser to `http://localhost:9001/api/health/` or use `curl` in command line.

```
curl -v -k http://localhost:9001/api/health/
```
