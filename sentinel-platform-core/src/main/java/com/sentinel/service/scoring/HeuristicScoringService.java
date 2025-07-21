package com.sentinel.service.scoring;

import org.springframework.stereotype.Component;
import com.sentinel.dto.DeviceEventRequest;

@Component
public class HeuristicScoringService {

    public double calculate(DeviceEventRequest req) {
        double score = 100.0;

        if (req.isRooted()) score -= 30;
        if (req.getIp().startsWith("10.")) score -= 10;
        if (!req.getLocation().toString().equalsIgnoreCase("BR")) score -= 15;

        return Math.max(score, 0);
    }
}

