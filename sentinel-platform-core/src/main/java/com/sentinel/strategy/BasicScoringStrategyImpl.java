package com.sentinel.strategy;

import com.sentinel.dto.DeviceEventRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasicScoringStrategyImpl implements RiskScoringStrategy {

    @Override
    public double calculateScore(DeviceEventRequest request) {
        int score = 100;

        // Regra: dispositivo com root = risco alto
        if (request.isRooted()) {
            score -= 40;
        }

        // Regra: IP inválido
        if (request.getIp() == null || request.getIp().isBlank()) {
            score -= 10;
        }

        // Regra: sensor de acelerômetro anormal
        if (request.getSensors() != null) {
            String pattern = request.getSensors().getAccelerometerPattern();
            if ("abnormal".equalsIgnoreCase(pattern)) {
                score -= 20;
            }
        }

        // Regra: localização ausente
        if (request.getLocation() == null) {
            score -= 15;
        }

        // Garantir que o score fique entre 0 e 100
        return Math.max(0, Math.min(score, 100));
    }
}