From openjdk:8
copy ./target/email-service-0.0.1-SNAPSHOT.jar email-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","email-service-0.0.1-SNAPSHOT.jar"]