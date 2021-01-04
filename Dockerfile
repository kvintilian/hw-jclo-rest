FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/demo-0.0.1-SNAPSHOT.jar springbootapp.jar
ENTRYPOINT ["java","-jar","/springbootapp.jar"]