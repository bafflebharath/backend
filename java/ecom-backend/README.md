# Spring Security Architecture Overview

## Introduction

This repository serves as a comprehensive guide to understanding the Spring Security Architecture, covering crucial packages, interfaces, and classes responsible for handling authentication and authorization requests in web applications. It delves into various security topics including CORS, CSRF, JWT, OAuth2, password management, method-level security, and user/role management within web applications.

## Topics Covered

- Overview of Spring Security framework and its features
- Adapting security for Java web applications using Spring Security
- Password management with PasswordEncoders in Spring Security
- Deep dive into encoding, encryption, and hashing techniques
- Understanding CSRF, CORS, and their mitigation strategies
- Differentiating Authentication and Authorization
- Securing endpoint URLs with Ant, MVC, and Regex Matchers
- Filters in Spring Security and creating custom filters
- Exploring JSON Web Tokens (JWT) and their role in Authentication & Authorization
- Understanding OAuth2 and its various grant type flows
- Exploring OpenID Connect and its relationship with OAuth2
- Applying authorization rules using roles and authorities in Spring Security
- Method-level security in web and non-web applications
- Integrating social login into web applications
- Setting up an Authorization Server using KeyCloak

## Pre-requisite

- Good understanding of Java and Spring concepts
- Basic familiarity with Spring Boot and REST services (optional)
- Curiosity and enthusiasm to explore Spring Security

## Software Pre-requisite

To follow along with the course, ensure you have the following software installed on your machine:

- Java Development Kit (JDK)
- Spring Boot
- MongoDB
- MongoDB Compass
- Postman

## Installation Steps

Follow these steps to set up the environment for running the course materials:

1. **Java Development Kit (JDK)**:
    - Download and install the JDK from the official Oracle website: [Java SE Downloads](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
    - Verify the installation by running `java -version` in your terminal/command prompt.

2. **Spring Boot**:
    - Set up a new Spring Boot project using Spring Initializr: [Spring Initializr](https://start.spring.io/)
    - Follow the instructions provided on the website to generate a Spring Boot project with the dependencies you need.

3. **MongoDB**:
    - Install MongoDB on your machine by following the official installation guide: [MongoDB Installation](https://docs.mongodb.com/manual/installation/)
    - Start the MongoDB server by running `mongod` in your terminal/command prompt.

4. **MongoDB Compass**:
    - Download and install MongoDB Compass from the official website: [MongoDB Compass](https://www.mongodb.com/try/download/compass)
    - MongoDB Compass provides a graphical user interface to interact with MongoDB databases.

5. **Postman**:
    - Download and install Postman from the official website: [Download Postman](https://www.postman.com/downloads/)
    - Postman will be used to interact with the RESTful APIs provided by the Spring Boot application.
