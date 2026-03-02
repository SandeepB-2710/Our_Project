# 🚀 InfoCircle Backend – Spring Boot REST API

## 📌 Overview

InfoCircle Backend is a secure RESTful API built using **Spring Boot 3**.

It provides:

- Authentication & Authorization  
- Role-Based Access Control (USER / ADMIN)  
- Category Management  
- Post Management  
- Profile Image Upload functionality  

The application uses **JWT-based authentication**, **Spring Security**, and **MySQL** for persistent storage.  
It is fully containerized using **Docker** for consistent deployment.

**API Base URL:**  
http://localhost:8080/api  

**Swagger Documentation:**  
http://localhost:8080/swagger-ui/index.html  

---

## 🛠 Tech Stack

- Java 17  
- Spring Boot 3  
- Spring Security (JWT Authentication)  
- Spring Data JPA  
- Hibernate  
- MySQL  
- ModelMapper  
- Lombok  
- Docker  

---

## ✨ Features

- ✅ User Registration & Login  
- ✅ JWT Token Generation  
- ✅ Stateless Session Management  
- ✅ Role-Based Access Control (USER / ADMIN)  
- ✅ Create / Update / Delete Posts  
- ✅ Category CRUD Operations  
- ✅ Search Category by Title API  
- ✅ Profile Image Upload (Stored in Folder, Not as BLOB)  
- ✅ Custom `ResourceNotFoundException`  
- ✅ Global Exception Handling (`@ControllerAdvice`)  
- ✅ CORS Configuration  
- ✅ Dockerized Backend Setup  

---

## 🔐 Authentication & Security

- JWT-based Authentication  
- Stateless Session Management  
- Role-Based Authorization  
- Custom Exception Handling  
- Clean exception architecture  
- Secure API endpoint protection
