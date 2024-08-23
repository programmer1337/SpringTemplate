FROM openjdk:22
LABEL authors="programmer1337"

ARG JAR_FILE
COPY ${JAR_FILE} /app.jar

CMD java -XX:+ExitOnOutOfMemoryError \
    -Djava.security.egd=file:/dev/./urandom \
    -jar /app.jar

EXPOSE 8080
