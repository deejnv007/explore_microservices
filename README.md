# Microservices Application: Question Bank and Quiz Service

This repository contains a Spring Boot microservices architecture that implements a **Question Bank** service and a **Quiz** service. The setup also integrates with a **Service Registry** (Eureka) and an **API Gateway** (Spring Cloud Gateway) for seamless service discovery and routing.

---

## Features

- **Microservices**: Independent services for managing questions and quizzes.
- **Service Registry**: Eureka server for service discovery.
- **API Gateway**: Spring Cloud Gateway for routing requests.
- **RESTful Endpoints**: CRUD operations for `Question` and `Quiz` entities.
- **Loose Coupling**: Services communicate through the gateway and service registry.
- **Test Endpoint**: A test controller is included in the Quiz service for basic functionality validation.

---

## Architecture Overview

1. **Question Bank Service** (`QuestionBank`):
   - Manages questions with endpoints for CRUD operations.
   - Endpoints:
     - `POST /question`: Add a new question.
     - `GET /question`: Retrieve all questions.
     - `GET /question/{id}`: Retrieve a specific question by ID.
     - `GET /question/quiz/{quizId}`: Retrieve questions for a specific quiz.

2. **Quiz Service** (`QuizService`):
   - Manages quizzes with CRUD endpoints.
   - Endpoints:
     - `POST /quiz`: Add a new quiz.
     - `GET /quiz`: Retrieve all quizzes.
     - `GET /quiz/{id}`: Retrieve a specific quiz by ID.
     - `GET /quiz-test`: Test endpoint for debugging.

3. **Service Registry** (Eureka Server):
   - Registers the `QuestionBank` and `QuizService` instances.
   - Enables dynamic service discovery.

4. **API Gateway**:
   - Routes external requests to appropriate services based on path prefixes.
   - Example routes:
     - `/question/**` → `QuestionBank` Service.
     - `/quiz/**` → `QuizService`.

---

## Getting Started

### Prerequisites

- **Java 17+**
- **Maven** or **Gradle**
- **Docker** (optional, for containerization)

---

### Setup
Run the Eureka Server:

Navigate to the Eureka Server module and run the Spring Boot application.
Start the Microservices:

Run the QuestionBank and QuizService applications.
Run the API Gateway:

Start the Gateway application to enable routing.

Usage
Access the Question Bank Service:
Example: http://<gateway-url>/question
Access the Quiz Service:
Example: http://<gateway-url>/quiz

## Sample API Requests

1. Add a Question:
POST /question
Content-Type: application/json
Body:
{
    "id": 1,
    "content": "What is Java?",
    "quizId": 101
}

2. Retrieve All Questions:
GET /question

3. Add a Quiz:
POST /quiz
Content-Type: application/json
Body:
{
    "id": 101,
    "title": "Java Basics Quiz"
}

4. Test Quiz Controller:
GET /quiz-test

## Folder Structure
src/
├── main/
│   ├── java/com/microservice/
│   │   ├── QuestionBank/               # Question Service
│   │   ├── QuizService/                # Quiz Service
│   │   ├── EurekaServer/               # Service Registry
│   │   └── APIGateway/                 # API Gateway
│   └── resources/
├── test/
└── pom.xml                             # Maven Dependencies

## Dependencies Used
* Spring Boot Starter Web
* Spring Boot Starter Data JPA
* Spring Boot Starter Eureka Client
* Spring Cloud Gateway
* H2 Database (for development)

