## How to deploy the backEnd on Render.com



1. Create a DockerFile in the root of the backEnd application
2. Choose Web Services on Render.com, free plan and click on deploy (You can change the name of you want)

```shell
# Use a base image with Java
FROM maven:3.9.5-eclipse-temurin AS build

# Copy the project in the build
COPY . .

# Command to install our package
RUN mvn clean package -DskipTests

# From the container
FROM openjdk:21-jdk-slim

COPY --from=build /target/AnimeQuiz-0.0.1-SNAPSHOT.jar AnimeQuiz.jar

# Expose the port that Spring Boot runs on
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "AnimeQuiz.jar"]
```
---
## Backend Url
``
https://animequiz-api.onrender.com
``
