package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.Component;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.ComponentReadRepository;
import com.gmkw.jznee.repository.write.ComponentWriteRepository;
import com.gmkw.jznee.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "components")
public class ComponentServiceImpl implements ComponentService {
    @Autowired
    private ComponentReadRepository componentReadRepository;

    @Autowired
    private ComponentWriteRepository componentWriteRepository;


    @Override
    @Cacheable(key = "'components'")
    public RestResult getComponents() {
        return new RestResult(Constants.STATE_SUCCESS, "",componentReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'components'")
//    public RestResult saveComponent(String type, String warehouseBy, String location, String picPath) {
    public RestResult addComponent() {
        Component component = new Component();

        component.setBatchNumber("testtest");
        component.setCode("testCode");
        component.setComponentNumber("cncncncncncn");
        component.setCurrentSequenceId(000001L);
        component.setCurrentSequenceTime(new Timestamp(new Date().getTime()));
        component.setLocation(Location.A1);
        component.setMaterial("material");
        component.setName("name");
        component.setNumber("number");
        component.setParentId(888888L);
        component.setPicNumber("picnumber01");
        component.setPicPath("picPath01");
        component.setPurchaseId(80808080L);
        component.setPurchaseName("purchaseName");
        component.setPurchaseNumber("purchasenumber01");
        component.setPurchaseTime(new Timestamp(new Date().getTime()));
        component.setSpecification("specification");
        component.setSupplier("supplier");

        componentWriteRepository.save(component);
        return new RestResult(Constants.STATE_SUCCESS, "",component);
    }

    @Override
    @CachePut(key = "'component_' +  #componentId")
    @CacheEvict(key = "'components'")
    public RestResult updateComponent(Long componentId) {
        Component component = componentReadRepository.findComponentById(componentId);

        component.setBatchNumber("testtest");
        component.setCode("testCode");
        component.setComponentNumber("cncncncncncn");
        component.setCurrentSequenceId(000001L);
        component.setCurrentSequenceTime(new Timestamp(new Date().getTime()));
        component.setLocation(Location.A2);
        component.setMaterial("material");
        component.setName("name");
        component.setNumber("number");
        component.setParentId(888888L);
        component.setPicNumber("picnumber02");
        component.setPicPath("picPath01");
        component.setPurchaseId(80808080L);
        component.setPurchaseName("purchaseName");
        component.setPurchaseNumber("purchasenumber02");
        component.setPurchaseTime(new Timestamp(new Date().getTime()));
        component.setSpecification("specification");
        component.setSupplier("supplier");


        return new RestResult(Constants.STATE_SUCCESS, "",component);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'components'"), @CacheEvict(key = "'component_' +  #componentId") })
    public RestResult deleteComponent(Long componentId) {
        componentWriteRepository.deleteComponentById(componentId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'component_' +  #componentId")
    public RestResult getComponentById(Long componentId) {
        return new RestResult(Constants.STATE_SUCCESS, "",componentReadRepository.findComponentById(componentId));
    }
}
