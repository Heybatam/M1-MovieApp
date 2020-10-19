FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8686
ADD ./build/libs/product-service-0.0.1-SNAPSHOT.jar app1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app1.jar"]