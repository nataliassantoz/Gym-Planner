# Usa a imagem oficial do Java
FROM openjdk:17-jdk-alpine

# Cria diretório para a aplicação
WORKDIR /app

# Copia o jar gerado para dentro do container
COPY target/gymplanner-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
