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