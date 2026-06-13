FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080
CMD ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]
