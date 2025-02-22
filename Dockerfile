# Stage 1: Build the application
FROM maven:3.9.5-eclipse-temurin AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:21-jre-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/AnimeQuiz-0.0.1-SNAPSHOT.jar AnimeQuiz.jar

# Expose the port that Spring Boot runs on
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "AnimeQuiz.jar"]