FROM java:8
FROM maven:alpine

# image layer

WORKDIR /app/ExcelService

# Image layer: with the application

COPY ./ExcelService /app/ExcelService

RUN mvn -v

RUN mvn clean install -DskipTests

ENTRYPOINT ["java","-jar","/app/ExcelService/target/ExcelService-0.0.1-SNAPSHOT.jar"]