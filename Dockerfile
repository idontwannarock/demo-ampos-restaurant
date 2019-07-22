FROM openjdk:8
MAINTAINER Howard
VOLUME /tmp
EXPOSE 9000
ARG JAR_FILE=target/demo-ampos-restaurant-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} demo-ampos-restaurant-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demo-ampos-restaurant-0.0.1-SNAPSHOT.jar"]