# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the local project files to the container
COPY . /app

# Compile the Java project (adjust if using Maven or Gradle)
RUN ./mvnw clean install

# Run the application
CMD ["java", "-jar", "target/clinic-management-system.jar"]
