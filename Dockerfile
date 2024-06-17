# Use a base image containing Java runtime
FROM openjdk:11-jre-slim

# Use a base image
FROM alpine:latest

# Add Maintainer Info
LABEL maintainer="priyanshusingh6014@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Print the contents of the current directory
CMD ls -l

# The application's jar file
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} demo.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/demo.jar"]
