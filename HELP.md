# Getting Started

## Pre-requisites

These event driven applications are built on: [Spring Boot][boot], [Maven][maven], and [Java 11][java].


### Run App

cd invoice

mvnw clean package -Dmaven.test.skip=true

##### Make sure of port 9098 is not in use
mvnw spring-boot:run

    or

java -jar target/invoice-0.0.1-SNAPSHOT.jar

### Kafka consumer support
#### Kafka server should be run and kafka settings adjusted to running server

mvnw spring-boot:run -Dspring-boot.run.profiles=kafka

### OpenApi 3 specification (Invoice service should running)

* [OpenApi 3.0.1 json specification](http://localhost:8080/v3/api-docs)
* [OpenApi 3.0.1 Swagger UI](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config)
