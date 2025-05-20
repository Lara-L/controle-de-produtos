# Usando a imagem oficial do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para o container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta usada pela aplicação
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
