FROM openjdk:8
MAINTAINER zalatnai.hu
COPY target/happyornot-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/app.jar"]
EXPOSE 8080
