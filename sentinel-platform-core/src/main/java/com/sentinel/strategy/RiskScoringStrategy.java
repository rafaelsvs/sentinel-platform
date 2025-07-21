package com.sentinel.strategy;

import com.sentinel.dto.DeviceEventRequest;

public interface RiskScoringStrategy {
    double calculateScore(DeviceEventRequest request);
}