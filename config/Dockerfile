FROM eclipse-temurin:22

LABEL maintainer = "julian5335"
LABEL name = "Config"

RUN mkdir /opt/app

COPY target/config-0.0.1-SNAPSHOT.jar opt/app/app.jar

ENTRYPOINT [ "java", "-jar", "opt/app/app.jar" ]