# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set environment variables
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE=prod

# Set the working directory
WORKDIR /app

# Copy the built jar file into the container
COPY target/mongo-db-0.0.1-SNAPSHOT.jar  app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
