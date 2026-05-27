# JPMorgan Report Service

A full-stack REST API for managing regulatory reports, built with Java and
Spring Boot, backed by a PostgreSQL database. Built as preparation for a
JPMorgan Chase Software Engineer internship.

## What it does

This service manages regulatory reports (like HMDA mortgage filings and DFAST
capital assessments) through a complete REST API. It supports creating, reading,
updating, and deleting reports, with all data persisted in a PostgreSQL database.

## Tech stack

- **Java 21** — core language
- **Spring Boot 3.5** — backend framework
- **Spring Data JPA** — database access layer
- **PostgreSQL** — relational database
- **Maven** — build and dependency management

## Architecture

The application follows a layered architecture:

Controller -> Service -> Repository -> Database

- **Controller** — handles incoming HTTP requests and routes them
- **Service** — contains business logic
- **Repository** — translates Java calls into SQL via Spring Data JPA
- **Database** — PostgreSQL stores all report data persistently

## API endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/reports/all` | Get all reports |
| POST | `/reports` | Create a new report |
| PUT | `/reports/{id}` | Update a report's status |
| DELETE | `/reports/{id}` | Delete a report |

## How to run

1. Make sure PostgreSQL is running and a database named `reportdb` exists
2. Update `application.properties` with your database credentials
3. Run the application:

   ./mvnw spring-boot:run

4. The API will be available at `http://localhost:8080`

## What I learned

Building this project taught me REST API design, the Spring Boot
controller-service-repository pattern, dependency injection, JPA entity
mapping, and how to connect a backend to a relational database.