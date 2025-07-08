# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file into the container
COPY target/smart-clinic-management-system-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
