FROM openjdk:20-jdk-slim
ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_asistencia.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar", "/app_asistencia.app"]