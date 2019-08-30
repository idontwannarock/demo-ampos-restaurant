FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package -DskipTests -Pdocker

FROM openjdk:8-jre-alpine
COPY --from=builder /app/target/demo-ampos-restaurant-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]