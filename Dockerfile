FROM openjdk:11
MAINTAINER Fabian Stäber, fabian@fstab.de
COPY target/hello-world.jar .
EXPOSE 8080
CMD ["java", "-jar", "hello-world.jar"]
