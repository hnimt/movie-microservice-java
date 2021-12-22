FROM java:8
FROM maven:alpine

# image layer

WORKDIR /app/ZuulGateway

# Image layer: with the application

COPY ./ZuulGateway /app/ZuulGateway

RUN mvn -v

RUN mvn clean install -DskipTests

ENTRYPOINT ["java","-jar","/app/ZuulGateway/target/ZuulGateway-0.0.1-SNAPSHOT.jar"]