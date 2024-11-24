# MovieTrack - Sistema de Cadastro de Filmes: Backend

Este é o backend do sistema de cadastro de filmes, desenvolvido em **Spring Boot**. Ele gerencia o cadastro de usuários, autenticação e todas as operações relacionadas aos filmes. Para acessar o repositório do frontend, clique no link abaixo:

[Repositório do Frontend](#)

## Tecnologias Utilizadas

- [**Spring Boot**](https://spring.io/projects/spring-boot)

## Funcionalidades

### Usuários
- **Cadastro:** Cria o usuário no Firebase, salva informações no banco de dados e gerencia cookies de sessão.
- **Login:** Valida credenciais no Firebase, gerencia cookies de sessão e armazena informações da requisição.

### Filmes
- **Cadastrar Filme:** Permite ao usuário autenticado adicionar um novo filme com campos obrigatórios e, opcionalmente, fazer upload de uma capa.
- **Listar Filmes:** Retorna todos os filmes cadastrados pelo usuário autenticado.
- **Atualizar Filme:** Permite modificar dados de um filme específico, validando a autenticação e propriedade.
- **Excluir Filme:** Remove um filme do banco de dados após validação de autenticação e propriedade.

## Como Executar

1. Clone o repositório.
2. Configure as variáveis de ambiente para integração com Firebase e banco de dados.
3. Execute o projeto com seu IDE ou usando o comando:  
   ```bash
   ./mvnw spring-boot:run
