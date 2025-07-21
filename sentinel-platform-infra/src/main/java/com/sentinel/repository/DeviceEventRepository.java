package com.sentinel.repository;

import com.sentinel.model.DeviceEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceEventRepository extends JpaRepository<DeviceEventEntity, String> {

    List<DeviceEventEntity> findTop1ByDeviceIdOrderByCreatedAtDesc(String deviceId);

    List<DeviceEventEntity> findAllByDeviceId(String deviceId);

    @Query("SELECT COUNT(*) FROM DeviceEvent e WHERE e.deviceId = :deviceId AND e.flagged = true")
    long countFlags(@Param("deviceId") String deviceId);

    @Query("SELECT COUNT(*) FROM DeviceEvent e WHERE e.deviceId = :deviceId")
    long countEvents(@Param("deviceId") String deviceId);

}