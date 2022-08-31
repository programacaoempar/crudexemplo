FROM openjdk:latest
VOLUME /tmp
ADD target/demo-spring-boot-0.0.1-SNAPSHOT.jar demo-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-spring-boot.jar"]