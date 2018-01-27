FROM openjdk:8-jre-alpine
COPY ./build/libs/trainingtodo-core-service-1.0.0.jar /usr/src/workouttodo/
WORKDIR /usr/src/workouttodo
EXPOSE 8080
CMD ["java", "-jar", "trainingtodo-core-service-1.0.0.jar"]
