package com.sentinel.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class DeviceEventRequest {

    @NotBlank
    private String deviceId;

    @NotBlank
    private String userId;

    @NotBlank
    private String ip;

    @NotBlank
    private String os;

    @NotBlank
    private String osVersion;

    @NotBlank
    private String appVersion;

    @NotNull
    private Location location;

    private boolean rooted;

    private Sensors sensors;

    @NotNull
    private Instant timestamp;

    @Data
    public static class Location {
        private double lat;
        private double lon;
    }

    @Data
    public static class Sensors {
        private String accelerometerPattern;
    }
}