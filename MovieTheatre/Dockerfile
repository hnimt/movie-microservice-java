FROM java:8
FROM maven:alpine

# image layer

WORKDIR /app/MovieTheatre

# Image layer: with the application

COPY ./MovieTheatre /app/MovieTheatre

RUN mvn -v

RUN mvn clean install -DskipTests

ENTRYPOINT ["java","-jar","/app/MovieTheatre/target/MovieTheatre-0.0.1-SNAPSHOT.jar"]