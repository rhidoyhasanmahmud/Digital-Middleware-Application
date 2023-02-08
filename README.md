# Middleware Application

A simple Middleware Application with Java and Spring Boot.

## High Level Design

![USER_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Backend/main/images/Middleware_Application_High_Level_Design.PNG)

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

Then you can visit the base url in this url- `http://localhost:7007/v1`.

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

![USER_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Backend/main/images/USER_TABLE.PNG)

> 2. MW_HISTORY : Logging All User Request details with Time.

![HISTORY_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Backend/main/images/HISTORY_TABLE.PNG)

> 3. MW_COURIER : Courier-Rate Details Information. Load data through Scheduler and have manual process for sync
     realtime data.

![COURIER_TABLE](https://raw.githubusercontent.com/CodeMechanix/Digital-Backend/main/images/COURIER_TABLE.PNG)

## Swagger UI

![Swagger UI](https://raw.githubusercontent.com/CodeMechanix/Digital-Backend/main/images/Swagger-UI.PNG)

## Postman UI
![Postman UI](https://raw.githubusercontent.com/CodeMechanix/Digital-Backend/main/images/Postman-UI.PNG)

## Developer

**Hasan Mahmud Rhidoy<br>
hasan.mahmud8177@gmail.com<br>
<https://sites.google.com/view/codemechanixhasan/home>**