package com.sentinel.strategy;

import com.sentinel.dto.DeviceEventRequest;

public interface RiskScoringStrategy {
    int calculateScore(DeviceEventRequest request);
}