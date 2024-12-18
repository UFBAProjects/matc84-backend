# MovieTrack - Sistema de Cadastro de Filmes: Backend

Este é o backend do sistema de cadastro de filmes, desenvolvido em **Spring Boot**. Ele gerencia o cadastro de usuários, autenticação e todas as operações relacionadas aos filmes. Para acessar o repositório do frontend, clique no link abaixo:

[Repositório do Frontend](https://github.com/UFBAProjects/matc84-frontend)

## Tecnologias Utilizadas

- [**Spring Boot**](https://spring.io/projects/spring-boot)

## Funcionalidades

### Usuários
- **Cadastro:** Cria o usuário, salva informações no banco de dados e gerencia cookies de sessão.
- **Login:** Valida credenciais, gerencia cookies de sessão e armazena informações da requisição.

### Filmes
- **Cadastrar Filme:** Permite ao usuário autenticado adicionar um novo filme com campos obrigatórios e, opcionalmente, fazer upload de uma capa.
- **Listar Filmes:** Retorna todos os filmes cadastrados pelo usuário autenticado.
- **Atualizar Filme:** Permite modificar dados de um filme específico, validando a autenticação e propriedade.
- **Excluir Filme:** Remove um filme do banco de dados após validação de autenticação e propriedade.

## Como Executar

1. Clone o repositório.
2. Configure as variáveis de ambiente para integração com o banco de dados, através do arquivo 'resources/application.properties'.
3. Execute o projeto com seu IDE ou usando o comando:  
   ```bash
   ./mvnw spring-boot:run

# Rotas

| METHOD | PATH                    | 
|--------|-------------------------|
| POST   | /filmes/cadastrar       |
| GET    | /filmes/listar/:user_id |
| PUT    | /filmes/atualizar/{id}  |
| DELETE | /filmes/deletar/:id     |
Rotas protegidas.

Exemplo POST:
```
{
  "titulo": "O Poderoso Chefão",
  "genero": "Drama",
  "anoLancamento": 1972,
  "descricao": "Um épico sobre a família Corleone e sua luta pelo poder no submundo do crime.",
  "capa": "https://exemplo.com/imagens/capa-poderoso-chefao.jpg",
  "user_id": 1
}
```


| METHOD | PATH        | 
|--------|-------------|
| POST   | /auth/login |
Exemplo POST:
```
{
  "email": "email@exemplo.com",
  "senha": "senha123"
}
```

| METHOD | PATH      | 
|--------|-----------|
| POST   | /usuarios |

Exemplo POST:
```
{
  "nome": "Seu Nome",
  "email": "email@exemplo.com",
  "senha": "senha123"
}

```