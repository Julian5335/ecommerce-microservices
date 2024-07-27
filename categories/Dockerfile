FROM eclipse-temurin:22

LABEL maintainer = "julian5335"
LABEL name = "Categories"

RUN mkdir /opt/app

COPY target/categories-0.0.1-SNAPSHOT.jar opt/app/app.jar

ENTRYPOINT [ "java", "-jar", "opt/app/app.jar" ]