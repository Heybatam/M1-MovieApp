FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8761
ADD ./build/libs/discovery-0.0.1-SNAPSHOT.jar app3.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app3.jar"]