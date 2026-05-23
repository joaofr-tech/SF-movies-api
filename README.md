# Movies San Francisco Map

API REST em Java com Spring Boot para consultar filmes gravados em San Francisco, usando dados publicos do portal SF Open Data.

## Sobre o projeto

Este projeto consome o dataset publico de filmes gravados em San Francisco e expoe os dados por meio de endpoints HTTP. A API retorna informacoes como titulo, ano de lancamento, local de filmagem e atores principais.

Fonte dos dados:

```text
https://data.sfgov.org/resource/yitu-d5am.json
```

## Tecnologias

- Java 17
- Spring Boot 4
- Spring Web MVC
- Spring WebFlux WebClient
- Maven
- Lombok

## Como executar

Clone o repositorio e entre na pasta do projeto:

```bash
git clone <url-do-repositorio>
cd movies-san-francisco-map
```

Execute a aplicacao com Maven:

```bash
./mvnw spring-boot:run
```

No Windows, use:

```powershell
.\mvnw.cmd spring-boot:run
```

Por padrao, a API fica disponivel em:

```text
http://localhost:8080
```

## Endpoints

### Listar filmes

```http
GET /movies
```

Exemplo:

```http
GET http://localhost:8080/movies
```

### Filtrar por titulo

```http
GET /movies?title=<titulo>
```

Exemplo:

```http
GET http://localhost:8080/movies?title=matrix
```

### Autocomplete de titulos

```http
GET /movies/autocomplete?q=<prefixo>
```

Exemplo:

```http
GET http://localhost:8080/movies/autocomplete?q=mi
```

## Exemplo de resposta

```json
[
  {
    "title": "Milk",
    "release_year": "2008",
    "locations": "El Camino Del Mar",
    "actor_1": "Sean Penn",
    "actor_2": "Emile Hirsch",
    "actor_3": null
  }
]
```

## Estrutura principal

```text
src/main/java/com/movies/map
├── MapApplication.java
├── controller/MovieController.java
├── model/MovieLocation.java
└── service/MovieLocationService.java
```

## Testando as rotas

O arquivo `src/docs/rest.http` pode ser usado em editores como VS Code ou IntelliJ para testar chamadas HTTP manualmente.

## Status

Projeto em desenvolvimento para praticar consumo de API externa, criacao de endpoints REST e organizacao de uma aplicacao Spring Boot.
