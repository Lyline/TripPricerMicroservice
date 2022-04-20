FROM openjdk:8-jdk-alpine3.9
ARG JAR_FILE=build/libs/tripPricerMicroservice-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} tripPricerMicroservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","tripPricerMicroservice-0.0.1-SNAPSHOT.jar" ]