FROM openjdk:8

RUN mkdir microservices
COPY ./target/coursemanagementspring-0.0.1-SNAPSHOT.jar ./microservices
EXPOSE 8080
ENTRYPOINT java -jar -Djava.net.preferIPv4Stack=true ./microservices/coursemanagementspring-0.0.1-SNAPSHOT.jar