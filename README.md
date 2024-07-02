# Flight Reservation API

Este projeto é uma API de reserva de voos construída usando Spring Boot e PostgreSQL. A API permite gerenciar voos (listar, criar, atualizar, deletar).
O conceito de Testes Unitários também foi implementado aqui neste projeto.

## Funcionalidades

- **Listar Voos**: A API permite buscar voos específicos fornecendo a cidade de origem, cidade de destino e data de embarque.
- **Criar Voo**: Adicionar um novo voo ao sistema.
- **Atualizar Voo**: Atualizar informações de um voo existente.
- **Deletar Voo**: Remover um voo do sistema.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data JPA**: Framework para simplificar o acesso a dados.
- **PostgreSQL**: Banco de dados relacional.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuração do Banco de Dados

1. Instale e configure o PostgreSQL.
2. Crie os bancos de dados para a aplicação:

   ```sql
   CREATE DATABASE voos;
   ```

3. No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao banco de dados:

   ```properties
    spring.datasource.url= jdbc:postgresql://localhost:5432/voos
    spring.datasource.username=postgres
    spring.datasource.password=*****
    spring.jpa.hibernate.ddl-auto=update

    spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
   ```
