# Rodando com Docker

## Build e execução

```bash
docker-compose up --build
```

## Estrutura

- `postgres`: banco de dados relacional
- `redis`: cache e armazenamento de sessões
- `api`: aplicação Spring Boot (porta 8080)

## Variáveis .env

```env
DB_HOST=postgres
DB_PORT=5432
DB_NAME=sentinel
DB_USER=sentinel_user
DB_PASSWORD=sentinel_pass
REDIS_HOST=redis
REDIS_PORT=6379
```