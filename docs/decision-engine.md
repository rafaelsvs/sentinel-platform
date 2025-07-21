# Engine de Decisão

A plataforma utiliza uma engine de pontuação baseada em regras (Rule-based Scoring) para avaliar riscos em tempo real.

## Estrutura do Score

- Valor de 0 a 100
- Classificação: LOW (0-39), MEDIUM (40-69), HIGH (70-100)

## Heurísticas

- **Sistema Operacional**: menos confiança em Androids antigos
- **Localização**: divergências entre IP e GPS geram alerta
- **Device Rooted**: pontuação cai drasticamente
- **Mudança de IP recorrente**: penaliza o score

Em breve: integração com modelos de Machine Learning para enriquecer a lógica.