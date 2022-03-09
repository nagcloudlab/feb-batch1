FROM adoptopenjdk:11-jre
WORKDIR application
COPY target/springboot-greeting-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]