FROM openjdk:8-jdk-alpine
MAINTAINER aakashjangidme.github.io
COPY target/playground-x-spring-boot-boilerplate-0.0.1-SNAPSHOT.jar playground-x-server-1.0.0.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/playground-x-server-1.0.0.jar"]