FROM maven:3.6.3-jdk-11-openj9
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

WORKDIR /tmp/
RUN cp /tmp/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
