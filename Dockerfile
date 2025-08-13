# Stage 1: Build using Maven and OpenJDK 21
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

# Stage 2: Create the final Docker image using OpenJDK 21
FROM eclipse-temurin:21-jdk
VOLUME /tmp
COPY --from=build /app/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080