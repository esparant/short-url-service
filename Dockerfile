# 1. Build Stage
FROM gradle:jdk21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle wrapper and settings files first to leverage Docker cache
COPY gradle /app/gradle
COPY gradlew /app/
COPY build.gradle /app/
COPY settings.gradle /app/

# Copy the rest of the application source code
COPY src /app/src

# Display the content of the project directory for debugging
RUN ls -al /app
RUN cat /app/build.gradle

# Clean and build the application, excluding tests and enabling parallel build
RUN ./gradlew clean build -x test --parallel

# 2. Runtime Stage
FROM amazoncorretto:21.0.3

# Set the working directory inside the container
WORKDIR /app

# Copy the built application from the build stage
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expose port (optional, adjust as needed)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/app.jar"]