FROM maven:3.8.4-openjdk-17
WORKDIR /cybus-performance-test
COPY src /cybus-performance-test/src
COPY pom.xml /cybus-performance-test