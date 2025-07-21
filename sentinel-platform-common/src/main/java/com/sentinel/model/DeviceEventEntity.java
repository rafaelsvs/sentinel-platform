package com.sentinel.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "device_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceEventEntity {

    @Id
    private String eventId;

    private String deviceId;
    private String userId;
    private String ip;
    private String os;
    private String osVersion;
    private String appVersion;
    private boolean rooted;
    private String accelerometerPattern;

    private Double latitude;
    private Double longitude;

    private Instant timestamp;

    private int score;

    private Instant createdAt;
}