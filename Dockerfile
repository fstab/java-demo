FROM openjdk:11
MAINTAINER Fabian Stäber, fabian@fstab.de
COPY target/demo-app.jar .
EXPOSE 8080
CMD ["java", "-jar", "demo-app.jar"]
