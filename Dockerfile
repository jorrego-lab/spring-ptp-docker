# ---- build ----
FROM maven:3.8-openjdk-8 AS build
WORKDIR /app
# cache deps first
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
# spring profile baked at build (default local). override: --build-arg PROFILE=produccion
ARG PROFILE=local
RUN mvn -B -P${PROFILE} clean package -DskipTests

# ---- run ----
FROM eclipse-temurin:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/placetopay-lightbox-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# runtime override of baked profile if needed: -e SPRING_PROFILES_ACTIVE=demo
ENTRYPOINT ["java", "-jar", "app.jar"]
