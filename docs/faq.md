# Perguntas Frequentes

## O container API não sobe. O que fazer?

- Verifique se o `app.jar` está sendo gerado corretamente em `/target`

## Como acesso o banco local?

- Host: `localhost`
- Porta: `5432`
- User: `sentinel_user`
- Senha: `sentinel_pass`
- Database: `sentinel`

## Como resetar os dados?

```bash
docker-compose down -v
```

## Como debuggar o Java dentro do container?

- Adicione `-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005` no `Dockerfile`