FROM java:8
FROM maven:alpine

# image layer

WORKDIR /app/AuthService

# Image layer: with the application

COPY ./AuthService /app/AuthService

RUN mvn -v

RUN mvn clean install -DskipTests

ENTRYPOINT ["java","-jar","/app/AuthService/target/AuthService-0.0.1-SNAPSHOT.jar"]