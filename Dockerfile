FROM openjdk:17-slim

WORKDIR /app

ARG JAR_FILE=sentinel-platform-api/target/sentinel-platform-api-1.0.0.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
