package com.sentinel.service.scoring;

import com.sentinel.dto.DeviceEventRequest;
import org.springframework.stereotype.Component;

@Component
public class MachineLearningScoringService {

    public double predict(DeviceEventRequest request) {
        // Em breve: chamar microserviço Python com modelo real
        return Math.random() * 100; // placeholder para simular IA
    }
}

