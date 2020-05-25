# bookdourado-back
Backend do projeto bookdourado.

# requisitos
Para executar o projeto você precisa das seguintes ferramentas

1. Java (JDK 8^)
2. Maven
3. Git (Se quiser clonar este repositório)
4. MySQL (Pode instalar o XAMPP, LAMPP ou MAMPP)

# como executar

1. Crie um banco de dados chamado challenge
2. Faça uma cópia desse repositório no seu disco rígido
3. Altere o usuario e a senha do banco no arquivo ~/src/main/java/resources/application.properties

`spring.datasource.username=challenge`

`spring.datasource.password=123456`

4. Abra o prompt de comando e digite os comandos

`cd c:\local\do\projeto`

`mvn clean install`

`mvn spring-boot:run`

5.  A documentação da API estará rodando em http://localhost:8080/swagger-ui.html
