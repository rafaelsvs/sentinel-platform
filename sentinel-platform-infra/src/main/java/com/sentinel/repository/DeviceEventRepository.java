package com.sentinel.repository;

import com.sentinel.model.DeviceEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceEventRepository extends JpaRepository<DeviceEventEntity, String> {

    List<DeviceEventEntity> findTop1ByDeviceIdOrderByCreatedAtDesc(String deviceId);

    List<DeviceEventEntity> findAllByDeviceId(String deviceId);
}