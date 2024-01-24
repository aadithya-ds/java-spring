#  FROM ubuntu:latest
#LABEL authors="Datasirpiprivate"
#
#ENTRYPOINT ["top", "-b"]


FROM openjdk:17

WORKDIR /app

COPY build/libs/*.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]