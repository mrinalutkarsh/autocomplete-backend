FROM  openjdk:8
ADD target/autocomplete.jar autocomplete.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "autocomplete.jar"]