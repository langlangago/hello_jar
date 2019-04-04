FROM openjdk:8u191-jdk-alpine

COPY target/*.jar /app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
