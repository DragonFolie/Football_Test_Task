FROM openjdk:11-jre-slim

COPY ["target/demo-0.0.1-SNAPSHOT.jar","demo-0.0.1-SNAPSHOT.jar"]

ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]



