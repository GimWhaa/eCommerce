# ---- Stage 1: Build the application ----
FROM openjdk:21-jdk AS build

# Set the working directory
WORKDIR /app

# Copy Maven wrapper and related files first (so Docker can cache dependencies)
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw

# Copy the pom.xml separately so dependencies can be cached
COPY pom.xml .

# Download dependencies (cached unless pom.xml changes)
RUN ./mvnw dependency:go-offline -B

# Now copy the source code
COPY src src

# Package the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# ---- Stage 2: Run the application ----
FROM openjdk:21-jdk

# Set working directory for runtime
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (or whatever your app uses)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
