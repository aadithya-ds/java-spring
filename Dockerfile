#FROM ubuntu:latest
#LABEL authors="Datasirpiprivate"
#
#ENTRYPOINT ["top", "-b"]


FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR into the container at /app
COPY build/libs/*.jar validation.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "validation.jar"]