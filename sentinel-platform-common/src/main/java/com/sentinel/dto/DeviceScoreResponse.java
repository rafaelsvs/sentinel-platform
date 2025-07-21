package com.sentinel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceScoreResponse {
    private String deviceId;
    private int score;
    private String lastUpdated;
}