FROM openjdk:11.0.7-jdk-slim

COPY ["target/demo-0.0.1-SNAPSHOT.jar","demo-0.0.1-SNAPSHOT.jar"]

ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]


