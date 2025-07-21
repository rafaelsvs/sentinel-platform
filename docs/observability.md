# Observabilidade

## A planejar para próximas releases:

- Integração com **OpenTelemetry**
- Exportação para **Grafana + Prometheus**
- Logs estruturados com MDC (correlação por request)
- Traço completo do ciclo da decisão de risco

## Hoje

- Logs com Spring Boot Actuator
- Expose de `/actuator/health`, `/actuator/info`, `/actuator/metrics`