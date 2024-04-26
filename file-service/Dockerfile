# Estágio de construção
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

# Copiar o arquivo pom.xml para o contêiner
COPY ./pom.xml .

# Copiar o diretório src para o contêiner
COPY ./src ./src

# Construir o projeto Maven, ignorando os testes
RUN mvn clean package -DskipTests

# Estágio de execução
FROM openjdk:17-jdk

WORKDIR /app

# Copiar o arquivo JAR construído anteriormente para o contêiner
COPY --from=build /app/target/file-service-0.0.1-SNAPSHOT.jar app.jar

# Copiar o arquivo CSV da raiz do projeto para o diretório de trabalho do contêiner
COPY arquivo.csv .

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar", "-"]
