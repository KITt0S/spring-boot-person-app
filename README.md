# Person Management REST API

A simple Spring Boot application for managing persons.  
Built to demonstrate skills in **Java**, **Spring Boot**, **REST APIs**, and **unit testing**.

## Features
- Create, read, update, delete (CRUD) persons
- In-memory storage (no database needed)
- REST API tested with **JUnit 5** and **MockMvc**

## Endpoints

| Method | Endpoint             | Params                        | Description              |
|--------|----------------------|-------------------------------|--------------------------|
| POST   | `/person/add`        | `name` (String), `age` (long)  | Add a new person         |
| GET    | `/person/get`        | `id` (long)                    | Get a person by ID       |
| POST   | `/person/update`     | `id` (long), `name`, `age`     | Update existing person   |
| DELETE | `/person/delete`     | `id` (long)                    | Delete a person by ID    |
| GET    | `/person/list`       | –                             | List all persons         |

## Run the Application
```bash
./gradlew bootRun
