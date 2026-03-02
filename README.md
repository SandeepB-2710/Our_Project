🚀 InfoCircle Backend – Spring Boot REST API
📌 Overview

InfoCircle Backend is a secure RESTful API built using Spring Boot 3.

It provides:

Authentication & Authorization
Role-based access control (USER / ADMIN)
Category Management
Post Management
Profile Image Upload functionality
The application uses JWT-based authentication, Spring Security, and MySQL for persistent storage.
It is fully containerized using Docker for consistent deployment.

API Base URL:
http://localhost:8080/api

Swagger Documentation:
http://localhost:8080/swagger-ui/index.html

🛠 Tech Stack

Java 17
Spring Boot 3
Spring Security (JWT Authentication)
Spring Data JPA
Hibernate
MySQL
ModelMapper
Lombok
Docker

✨ Features

✅ User Registration & Login
✅ JWT Token Generation
✅ Stateless Session Management
✅ Role-Based Access Control (USER / ADMIN)
✅ Create / Update / Delete Posts
✅ Category CRUD Operations
✅ Search Category by Title API
✅ Profile Image Upload (Stored in Folder, Not as BLOB)
✅ Custom ResourceNotFoundException
✅ Global Exception Handling (@ControllerAdvice)
✅ CORS Configuration
✅ Dockerized Backend Setup

🔐 Authentication & Security

JWT-based Authentication
Stateless Session Management
Role-Based Authorization
Custom Exception Handling
Clean exception architecture
Secure API endpoint protection

🔎 Sample API – Login

Endpoint:
POST /api/v1/auth/login

Response:
{
  "token": "jwt_token_here",
  "user": {
    "userId": 1,
    "email": "demo@gmail.com",
    "roles": ["USER"]
  }
}

📂 Get Category By Title

Endpoint:

GET /api/categories/title/{categoryTitle}

Example:

GET /api/categories/title/Technology

Docker volume used for persistence

🗂 Project Structure
Our_Project/
│
├── config/              (Security, JWT, CORS)
├── controller/          (REST Controllers)
├── dto/                 (Data Transfer Objects)
├── entity/              (JPA Entities)
├── exception/           (Custom Exceptions)
├── repository/          (Spring Data JPA)
├── service/             (Business Logic)

🧠 What I Learned

Designing secure REST APIs using Spring Security
Implementing JWT authentication
Proper use of Optional.orElseThrow()
Handling business exceptions using RuntimeException
Clean exception architecture using @ControllerAdvice
Managing CORS for Dockerized applications
Persisting file uploads using Docker volumes
Debugging container networking issues

⚙️ How to Run
1️⃣ Clone Repository
git clone https://github.com/SandeepB-2710/Our_Project/

cd Our_Project
2️⃣ Configure Database

Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/infocircle
spring.datasource.username=root
spring.datasource.password=your_password

3️⃣ Run Application (Local)
mvn spring-boot:run

Application runs on:
http://localhost:8080

🐳 Run Using Docker
Build Image
docker build -t infocircle-backend .
Run Container
docker run -p 8080:8080 infocircle-backend
Using Docker Compose (If Configured)
docker compose up --build
