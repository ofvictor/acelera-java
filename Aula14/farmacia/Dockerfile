FROM openjdk:8-jdk-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} farmacia.jar
ENTRYPOINT ["java","-jar","/farmacia.jar"]