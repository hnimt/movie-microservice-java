FROM java:8
FROM maven:alpine

# image layer

WORKDIR /app/EurekaServer

# Image layer: with the application

COPY ./EurekaServer /app/EurekaServer

RUN mvn -v

RUN mvn clean install -DskipTests

ENTRYPOINT ["java","-jar","/app/EurekaServer/target/EurekaServer-0.0.1-SNAPSHOT.jar"]