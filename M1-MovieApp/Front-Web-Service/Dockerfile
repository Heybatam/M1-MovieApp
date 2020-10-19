FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8585
ADD ./build/libs/Front-Web-Service-0.0.1-SNAPSHOT.jar app2.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app2.jar"]