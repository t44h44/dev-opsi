FROM openjdk:8
ADD target/achat-1.0.jar produit.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "produit.jar"]