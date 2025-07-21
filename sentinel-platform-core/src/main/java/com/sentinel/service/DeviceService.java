package com.sentinel.service;

import com.sentinel.dto.DeviceEventRequest;
import com.sentinel.dto.DeviceScoreResponse;
import com.sentinel.dto.DeviceAlertsResponse;

public interface DeviceService {

    String processDeviceEvent(DeviceEventRequest request);

    DeviceScoreResponse getDeviceScore(String deviceId);

    DeviceAlertsResponse getDeviceAlerts(String deviceId);
}