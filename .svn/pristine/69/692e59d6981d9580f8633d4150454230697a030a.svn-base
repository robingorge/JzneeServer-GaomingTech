package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface ComponentService {
    public RestResult getComponents();

    //    public RestResult saveComponent(String type, String warehouseBy, String location ,String picPath);
    public RestResult addComponent();

    public RestResult updateComponent(Long componentId);

    @Transactional
    public RestResult deleteComponent(Long componentId);

    public RestResult getComponentById(Long componentId);
}
