package com.sentinel.service.scoring;

import com.sentinel.repository.DeviceEventRepository;
import org.springframework.stereotype.Component;

@Component
public class ReputationService {

    private final DeviceEventRepository repo;

    public ReputationService(DeviceEventRepository repo) {
        this.repo = repo;
    }

    public double evaluateDevice(String deviceId) {
        long anomalies = repo.countFlags(deviceId);
        long total = repo.countEvents(deviceId);

        if (total == 0) return 50.0;

        double ratio = (double) anomalies / total;
        return 100.0 - (ratio * 100);
    }
}

