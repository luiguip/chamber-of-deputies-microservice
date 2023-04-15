# Ibge adapter hexagonal architecture

This project is a Brazillian Chamber of deputies microservice. 
It consumes a soap service and translates to a rest response to us.

## Hexagonal Architecture
Also known as ports and adapters architecture, it isolates the domain
from other modules, decoupling it from external dependencies.

## Project

It's separated in modules, where each module has a specific job:
* Application: Contains inbound adapters;
* Domain: Isolated layer that applies the business logic and contains the ports;
* Infrastructure: Contains outbound adapters;
* Launcher: Contains configurations and the application launcher.

## TODO

* Save data to a database;
* Tests;

## Technologies
- Maven
- Java 17
- Spring Boot
    - Spring web
    - Spring Test
    - Springdoc
- Lombok
- Junit
- Mockito
- Wiremock
- Open api
    - Swagger
- Docker
    - Docker compose
