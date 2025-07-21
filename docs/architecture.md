# Arquitetura da Sentinel Platform

A Sentinel foi construída seguindo uma arquitetura modular, separando responsabilidades por contexto para facilitar manutenção, escalabilidade e testes.

## Camadas e Módulos

### API Layer

- Exposição de endpoints REST
- Controladores HTTP

### Core Layer

- Lógica de negócio
- Engine de decisão de risco e pontuação

### Infra Layer

- Integrações com PostgreSQL, Redis e futuramente Kafka
- Repositórios

### Common Layer

- DTOs, entidades, enums e objetos compartilhados entre módulos

### Test Layer

- Cenários de testes automatizados e integração