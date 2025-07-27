# 📚 Quarkus Book Tracker

A simple RESTful API built with [Quarkus](https://quarkus.io/) to manage a personal book tracker.  
This project is designed for learning and evaluating Quarkus features like RESTEasy Reactive, Panache ORM, Hibernate Validator, and OpenAPI.

---

## 🚀 Features

- Track books with title, author, status, rating, and notes
- CRUD operations using REST endpoints
- In-memory H2 database for development
- Swagger UI for exploring the API
- Built using Quarkus with hot-reload support in dev mode

---

## 🔧 Run the Application in Dev Mode

```bash
./mvnw quarkus:dev
```

Dev UI available at: [http://localhost:8080/q/dev](http://localhost:8080/q/dev)  
Swagger UI: [http://localhost:8080/q/swagger-ui](http://localhost:8080/q/swagger-ui)

---

## 📦 Packaging the Application

Build a standard JAR:

```bash
./mvnw package
```

Run the application:

```bash
java -jar target/quarkus-app/quarkus-run.jar
```

Build an über-jar:

```bash
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

---

## 🧊 Create a Native Executable

Using GraalVM or container:

```bash
./mvnw package -Dnative
# or using container
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Run it:

```bash
./target/quarkus-book-tracker-1.0.0-SNAPSHOT-runner
```

---

## 📂 Key Endpoints

| Method | Endpoint         | Description             |
|--------|------------------|-------------------------|
| GET    | `/api/version`   | App version info        |
| GET    | `/api/books`     | List all books          |
| POST   | `/api/books`     | Create a new book       |
| GET    | `/api/books/{id}`| Get book by ID          |
| PUT    | `/api/books/{id}`| Update book by ID       |
| DELETE | `/api/books/{id}`| Delete book by ID       |

---

## 📚 Related Quarkus Guides

- [Hibernate ORM with Panache](https://quarkus.io/guides/hibernate-orm-panache)
- [RESTEasy Reactive](https://quarkus.io/guides/rest)
- [Hibernate Validator](https://quarkus.io/guides/validation)
- [SmallRye OpenAPI + Swagger UI](https://quarkus.io/guides/openapi-swaggerui)
- [H2 Database](https://quarkus.io/guides/datasource)

---

## 🧠 Author

Created by [@msg2santoshsagar](https://github.com/msg2santoshsagar) as a reference app to explore and learn Quarkus.
