FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/gamingBuddies-api-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]