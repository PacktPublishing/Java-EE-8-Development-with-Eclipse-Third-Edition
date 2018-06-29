FROM openjdk:8

ENV swarm.http.port 8080
RUN mkdir microservices
COPY ./target/coursemanagement-swarm.jar ./microservices
EXPOSE 8080
ENTRYPOINT java -jar -Djava.net.preferIPv4Stack=true ./microservices/coursemanagement-swarm.jar