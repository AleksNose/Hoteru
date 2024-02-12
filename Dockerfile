# FROM maven:3.8.4-openjdk-11-slim AS build
FROM azul/zulu-openjdk-alpine:17 AS build
WORKDIR /app

RUN apk add maven

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM azul/zulu-openjdk-alpine:17-jre
WORKDIR /app

COPY --from=build /app/target/hoteru-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "hoteru-0.0.1-SNAPSHOT.jar"]