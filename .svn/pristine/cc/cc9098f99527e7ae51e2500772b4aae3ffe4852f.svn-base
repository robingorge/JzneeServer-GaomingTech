package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface DeviceService {
    public RestResult getDevices();

    //    public RestResult saveDevice(String type, String warehouseBy, String location ,String picPath);
    public RestResult addDevice();

    public RestResult updateDevice(Long deviceId);

    @Transactional
    public RestResult deleteDevice(Long deviceId);

    public RestResult getDeviceById(Long deviceId);
}
