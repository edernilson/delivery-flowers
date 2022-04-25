FROM adoptopenjdk/openjdk8:alpine as builder
LABEL MAINTAINER="https://github.com/edernilson"
LABEL APPLICATION="Fornecedor Service"

WORKDIR /usr/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8100