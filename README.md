# Middleware Application

A simple Middleware Application with Java and Spring Boot.

## High Level Design

![USER_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Middleware-Backend/main/images/Middleware_Application_High_Level_Design.PNG?token=GHSAT0AAAAAAB2DE37FEU26LE6FCTUL5VBSY7EDCUQ)

## Installation

It's a Spring Boot and Java application with a very little functionality. Here are the commands you need to run one by
one-

```
git clone https://github.com/CodeMechanix/Digital-Backend.git
cd Digital-Backend
mvn clean
mvn spring-boot:run
```

Then you need to put your database credentials in the application-dev.yml file. I used PostgreSQL in this project.

Then you can visit the base url in this url- `http://localhost:7007/`.

## Docker Image Build

```text
# Build the Docker image using the following command:

docker build -t middleware .

# Once the image is built, run a container using the following command:

docker run -p 7007:7007 middleware

This will start a container and map port 7007 on the host to port 7007 in the container, making the Spring Boot application accessible on http://localhost:7007.
```



## Uses

This application can be used both in logged in or logged out state. But for using the full potential, you should logged
in.

This project has the following features-

- **PreAuthorize**: @PreAuthorize is an annotation in Spring Security that allows you to specify authorization rules for
  your application's endpoints. It can be used to define access control for methods in a Spring-based application.
- **Swagger**: Swagger is a popular open-source framework for building and documenting RESTful APIs. In a Spring Boot
  application, you can use the Swagger library to generate documentation for your API, which can be easily accessible
  and understandable by both developers and end-users.
- **API Security**: API Security purpose I used Authentication based API Data communication.
- **Logging**: Logging purpose, I use Database layer Request log and besides this file based log management system.
- **Unit Testing**: API coverage Unit Testing.
- Loosely couple design the Middleware Application.

## Database

> 1. MW_USER : Manage all Authenticate User Information.

![USER_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Middleware-Backend/main/images/USER_TABLE.PNG?token=GHSAT0AAAAAAB2DE37FA26JW4DX57QPUAFEY7EDDQQ)

> 2. MW_HISTORY : Logging All User Request details with Time. Beside this manage file base log. 

![HISTORY_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Middleware-Backend/main/images/HISTORY_TABLE.PNG?token=GHSAT0AAAAAAB2DE37FWU6A7ZG4N7ELHPAKY7EDCJQ)

> 3. MW_COURIER : Courier-Rate Details Information. Load data through Scheduler and have manual process for sync
     realtime data.

![COURIER_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Middleware-Backend/main/images/COURIER_TABLE.PNG?token=GHSAT0AAAAAAB2DE37FJEZADGX3JCLRSDZ4Y7EDBGA)

## Swagger UI

![Swagger UI](https://raw.githubusercontent.com/CodeMechanix/Digital-Middleware-Backend/main/images/Swagger-UI.PNG?token=GHSAT0AAAAAAB2DE37EZYTOH42PSSTT5NGMY7EDDIQ)

## Postman UI
![Postman UI](https://raw.githubusercontent.com/CodeMechanix/Digital-Middleware-Backend/main/images/Postman-UI.PNG?token=GHSAT0AAAAAAB2DE37F6LLYVSIHUXRZG4NAY7EDC7Q)

## Developer

**Hasan Mahmud Rhidoy<br>
hasan.mahmud8177@gmail.com<br>
<https://sites.google.com/view/codemechanixhasan/home>**
