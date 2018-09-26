package com.gmkw.jznee.repository.write;

import com.gmkw.jznee.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceWriteRepository extends JpaRepository<Device, Long> {
    public Long deleteDeviceById(Long deviceId);
}
