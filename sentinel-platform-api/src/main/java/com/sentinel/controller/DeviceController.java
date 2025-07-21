package com.sentinel.controller;

import com.sentinel.dto.DeviceEventRequest;
import com.sentinel.dto.DeviceScoreResponse;
import com.sentinel.dto.DeviceAlertsResponse;
import com.sentinel.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/event")
    public ResponseEntity<?> receiveDeviceEvent(@Valid @RequestBody DeviceEventRequest request) {
        String eventId = deviceService.processDeviceEvent(request);
        return ResponseEntity.ok().body(
                new ApiResponse("received", eventId)
        );
    }

    @GetMapping("/score/{deviceId}")
    public ResponseEntity<DeviceScoreResponse> getDeviceScore(@PathVariable("deviceId") String deviceId) {
        DeviceScoreResponse score = deviceService.getDeviceScore(deviceId);
        return ResponseEntity.ok(score);
    }

    // GET /device-alerts/{deviceId}
    @GetMapping("/alerts/{deviceId}")
    public ResponseEntity<DeviceAlertsResponse> getDeviceAlerts(@PathVariable String deviceId) {
        DeviceAlertsResponse alerts = deviceService.getDeviceAlerts(deviceId);
        return ResponseEntity.ok(alerts);
    }

    // Helper response class (could be moved to dto package)
    private record ApiResponse(String status, String eventId) {}
}
