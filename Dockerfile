FROM openjdk:8-jdk-alpine
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/izatec-api-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT java -jar izatec-api-0.0.1-SNAPSHOT.jar