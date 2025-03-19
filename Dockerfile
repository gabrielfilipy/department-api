FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/*.jar /app/sim-service-registry.jar

EXPOSE 8761

CMD ["java", "-jar", "sim-service-registry.jar"]