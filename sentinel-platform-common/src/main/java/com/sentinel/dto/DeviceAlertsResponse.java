package com.sentinel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DeviceAlertsResponse {

    private String deviceId;
    private List<Alert> alerts;

    @Data
    @AllArgsConstructor
    public static class Alert {
        private String code;
        private String message;
    }
}