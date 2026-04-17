# springboot-app

A starter Spring Boot 3 CRUD service — useful as a clean-slate template for a REST API with JPA persistence and actuator health checks.

## Stack

| Layer | Choice |
|---|---|
| Framework | Spring Boot 3 (Java 17) |
| Web | `spring-boot-starter-web` |
| Persistence | `spring-boot-starter-data-jpa` |
| Observability | `spring-boot-starter-actuator` |
| Boilerplate reduction | Lombok |
| Tests | `spring-boot-starter-test` |
| Build | Maven |
| Container | Dockerfile included |

## Run

```bash
./mvnw spring-boot:run
```

Starts on `http://localhost:8080`. Actuator endpoints are at `/actuator`.

## Build and run the jar

```bash
./mvnw clean package
java -jar target/crud-project-0.0.1-SNAPSHOT.jar
```

## Docker

```bash
docker build -t springboot-app .
docker run -p 8080:8080 springboot-app
```

## Configuration

Edit `src/main/resources/application.properties` (or add `application.yml`) for datasource, server port, and JPA/Hibernate settings.

## Project structure

```
src/
├── main/
│   ├── java/        # Controllers, entities, repositories, services
│   └── resources/   # application.properties, static, templates
└── test/
pom.xml
Dockerfile
```

## License

MIT
