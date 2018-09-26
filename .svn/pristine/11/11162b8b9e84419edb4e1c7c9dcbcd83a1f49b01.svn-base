package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/getDevices", method = {RequestMethod.POST})
    public RestResult getDevices(){
        return deviceService.getDevices();
    }

    @RequestMapping(value = "/addDevice", method = {RequestMethod.POST})
    public RestResult addDevice(){
        return deviceService.addDevice();
    }

    @RequestMapping(value = "/updateDevice", method = {RequestMethod.POST})
    public RestResult updateDevice(@RequestParam(value = "deviceId") Long deviceId){
        return deviceService.updateDevice(deviceId);
    }

    @RequestMapping(value = "/delDevice", method = {RequestMethod.POST})
    public RestResult delDevice(@RequestParam(value = "deviceId") Long deviceId){
        return deviceService.deleteDevice(deviceId);
    }

    @RequestMapping(value = "/getDeviceById", method = {RequestMethod.POST})
    public RestResult getDeviceById(@RequestParam(value = "deviceId") Long deviceId){
        return deviceService.getDeviceById(deviceId);
    }

}
