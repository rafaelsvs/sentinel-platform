# Sentinel: Device Trust & Intelligence Platform

Sentinel é uma plataforma backend projetada para avaliar, monitorar e pontuar a **confiabilidade de dispositivos** que interagem com sistemas sensíveis — como apps de logística, delivery ou fintechs.

O objetivo é **detectar comportamentos suspeitos, identificar fraudes em tempo real** e apoiar decisões automatizadas de risco e reputação.

---

## 🚀 Principais funcionalidades

- Coleta de sinais do dispositivo (sistema, IP, localização, fingerprint, root)
- Cálculo de **Device Trust Score (0 a 100)** com heurísticas ajustáveis
- Flags automáticas para anomalias e possíveis fraudes
- APIs REST para coleta de eventos e consulta de score
- Observabilidade de decisões e lógica rastreável
- Estrutura modular para evoluções futuras

---

## 🧱 Stack inicial

- Java 21 + Spring Boot 3
- PostgreSQL + Redis
- Docker
- OpenTelemetry (observabilidade futura)
- Kafka (ou simulação via fila local)
- JUnit + Testcontainers

---

## 📦 Endpoints iniciais

| Método | Rota                    | Descrição                                 |
|--------|-------------------------|-------------------------------------------|
| POST   | `/device-event`         | Recebe evento de dispositivo              |
| GET    | `/device-score/{id}`    | Retorna score e estado do dispositivo     |
| GET    | `/device-alerts/{id}`   | Lista alertas e flags do dispositivo      |

---

## 📈 Evoluções futuras

- Algoritmos de machine learning para pontuação dinâmica
- Integração com sistemas externos (Slack, PagerDuty, sistema de antifraude)
- Frontend para visualização dos dispositivos em tempo real
- API de feedback (reversões manuais de flags/scores)

---

## 🐳 Rodando com Docker

```bash
# Build do projeto
mvn clean install -DskipTests

# Subir a stack completa
docker-compose up --build
