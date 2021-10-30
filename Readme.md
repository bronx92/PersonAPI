## Sistema de gerenciamento de pessoas em API REST com Spring Boot

### Pequeno sistema para o gerenciamento de pessoas de uma empresa através de uma API REST, usando Spring Boot Framework.

* Projeto realizado com o Spring Boot Initialzr
* Operações (Cadastro, leitura, atualização e remoção de pessoas) seguindo padrão arquitetural Rest
* Persistência de dados com Spring Data JPA
* MapStruct
* Desenvolvimento de testes unitários com Spring Test
* Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```
São necessários os seguintes pré-requisitos para a execução do projeto
* Java 11 ou versões superiores.
* Maven 4.0.0 ou versões superiores.