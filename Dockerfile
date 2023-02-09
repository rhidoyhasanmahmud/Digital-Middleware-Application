# Use an official Java runtime as the base image
FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot jar file to the /app directory
COPY target/middleware.jar /app/middleware.jar

# Expose port 7007 for the Spring Boot application
EXPOSE 7007

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "middleware.jar"]





