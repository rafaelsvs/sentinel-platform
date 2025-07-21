# Ambiente de Desenvolvimento

## Requisitos

- Java 17+
- Maven 3.9+
- Docker (opcional)

## Clonagem e build

```bash
git clone https://github.com/rafaelsoares/sentinel-platform.git
cd sentinel-platform
mvn clean install -DskipTests
```

## Rodando com Docker

```bash
docker-compose up --build
```

## Rodando manualmente (sem Docker)

1. Suba o Postgres localmente
2. Crie a base de dados `sentinel`
3. Rode `SentinelPlatformApplication` no IntelliJ