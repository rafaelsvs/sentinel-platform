package com.sentinel.service;

import com.sentinel.dto.DeviceAlertsResponse;
import com.sentinel.dto.DeviceEventRequest;
import com.sentinel.dto.DeviceScoreResponse;
import com.sentinel.model.DeviceEventEntity;
import com.sentinel.repository.DeviceEventRepository;
import com.sentinel.strategy.RiskScoringStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    private final RiskScoringStrategy scoringStrategy;
    private final DeviceEventRepository deviceEventRepository;

    public DeviceServiceImpl(RiskScoringStrategy scoringStrategy,
                             DeviceEventRepository deviceEventRepository) {
        this.scoringStrategy = scoringStrategy;
        this.deviceEventRepository = deviceEventRepository;
    }

    @Override
    public String processDeviceEvent(DeviceEventRequest request) {
        double score = scoringStrategy.calculateScore(request);
        String eventId = UUID.randomUUID().toString();

        DeviceEventEntity entity = toEntity(request, score, eventId);
        deviceEventRepository.save(entity);

        log.info("Device event [{}] processed for deviceId={} with score={}", eventId, request.getDeviceId(), score);

        return eventId;
    }

    @Override
    public DeviceScoreResponse getDeviceScore(String deviceId) {
        // TODO: buscar último evento real (ainda está mockado)
        return new DeviceScoreResponse(deviceId, 85, Instant.now().toString());
    }

    @Override
    public DeviceAlertsResponse getDeviceAlerts(String deviceId) {
        // TODO: retornar alerts reais com base no evento (ainda mockado)
        return new DeviceAlertsResponse(deviceId, List.of(
                new DeviceAlertsResponse.Alert("ROOT_DETECTED", "Root access detected"),
                new DeviceAlertsResponse.Alert("MULTI_ACCOUNT", "Multiple accounts on same device")
        ));
    }

    private DeviceEventEntity toEntity(DeviceEventRequest request, double score, String eventId) {
        return DeviceEventEntity.builder()
                .eventId(eventId)
                .deviceId(request.getDeviceId())
                .userId(request.getUserId())
                .ip(request.getIp())
                .os(request.getOs())
                .osVersion(request.getOsVersion())
                .appVersion(request.getAppVersion())
                .rooted(request.isRooted())
                .accelerometerPattern(
                        Optional.ofNullable(request.getSensors())
                                .map(DeviceEventRequest.Sensors::getAccelerometerPattern)
                                .orElse(null))
                .latitude(
                        Optional.ofNullable(request.getLocation())
                                .map(DeviceEventRequest.Location::getLat)
                                .orElse(null))
                .longitude(
                        Optional.ofNullable(request.getLocation())
                                .map(DeviceEventRequest.Location::getLon)
                                .orElse(null))
                .timestamp(request.getTimestamp())
                .score(score)
                .createdAt(Instant.now())
                .build();
    }
}