FROM openjdk:8
MAINTAINER Howard
EXPOSE 9000
ADD target/demo-ampos-restaurant-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]