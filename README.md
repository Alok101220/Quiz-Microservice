# Quiz Management System

## Overview

Welcome to the Quiz Management System! This microservice-based application facilitates efficient quiz creation and access. Below, you'll find an overview of the key components, user flow, and the technology stack.

## Services

- **Question Service:** Manages questions for quizzes.
- **Quiz Service:** Handles quiz creation and access.
- **API Gateway Service:** Directs and manages traffic between services.
- **Service Registry:** Facilitates service discovery within the system.
- **Authentication Service:** Ensures secure user authentication.
- **User Service:** Manages user-related functionalities.

## User Flow

1. **Registration:**
   - Users register with a unique username and password.

2. **Login:**
   - Upon registration, users can log in with their credentials.

3. **Role-Based Access:**
   - Admins have the privilege to create quizzes.
   - Regular users can access quizzes but not create them.

## Key Components

- **Tech Stack:**
  - Java
  - Spring Boot
  - Eureka Cloud (Service Registry)
  - JWT Authentication (Security)
  - PostgreSQL (Database)

## Purpose

- Efficiently manages user registration, authentication, and quiz creation/access.
- Role-based access control ensures proper authorization for different user roles.

## Contributions

This is an open-source project, and we welcome contributions to enhance its features and capabilities. Feel free to explore, contribute, and improve the Quiz Management System!
