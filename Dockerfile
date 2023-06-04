FROM openjdk:17
MAINTAINER Romeu Franzoia Jr <rfranzoia@gmail.com>
VOLUME /tmp
EXPOSE 8080
ADD target/product-calculator.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]