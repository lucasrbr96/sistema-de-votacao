FROM maven:3-eclipse-temurin-20-alpine
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run