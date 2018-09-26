package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.entity.Device;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.DeviceReadRepository;
import com.gmkw.jznee.repository.write.DeviceWriteRepository;
import com.gmkw.jznee.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "devices")
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceReadRepository deviceReadRepository;

    @Autowired
    private DeviceWriteRepository deviceWriteRepository;


    @Override
    @Cacheable(key = "'devices'")
    public RestResult getDevices() {
        return new RestResult(Constants.STATE_SUCCESS, "",deviceReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'devices'")
//    public RestResult saveDevice(String type, String warehouseBy, String location, String picPath) {
    public RestResult addDevice() {
        Device device = new Device();

        device.setName("name");
        device.setNumber("number");
        device.setStatus(1);

        deviceWriteRepository.save(device);
        return new RestResult(Constants.STATE_SUCCESS, "",device);
    }

    @Override
    @CachePut(key = "'device_' +  #deviceId")
    @CacheEvict(key = "'devices'")
    public RestResult updateDevice(Long deviceId) {
        Device device = deviceReadRepository.findDeviceById(deviceId);

        device.setName("name");
        device.setNumber("number");
        device.setStatus(2);

        deviceWriteRepository.save(device);
        return new RestResult(Constants.STATE_SUCCESS, "",device);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'devices'"), @CacheEvict(key = "'device_' +  #deviceId") })
    public RestResult deleteDevice(Long deviceId) {
        deviceWriteRepository.deleteDeviceById(deviceId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'device_' +  #deviceId")
    public RestResult getDeviceById(Long deviceId) {
        return new RestResult(Constants.STATE_SUCCESS, "",deviceReadRepository.findDeviceById(deviceId));
    }
}
