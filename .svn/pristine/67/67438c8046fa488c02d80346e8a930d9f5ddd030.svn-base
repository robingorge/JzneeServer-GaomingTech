package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.Unit;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.UnitReadRepository;
import com.gmkw.jznee.repository.write.UnitWriteRepository;
import com.gmkw.jznee.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "units")
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitReadRepository unitReadRepository;

    @Autowired
    private UnitWriteRepository unitWriteRepository;


    @Override
    @Cacheable(key = "'units'")
    public RestResult getUnits() {
        return new RestResult(Constants.STATE_SUCCESS, "",unitReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'units'")
//    public RestResult saveUnit(String type, String warehouseBy, String location, String picPath) {
    public RestResult addUnit() {
        Unit unit = new Unit();

        unit.setCode("code");
        unit.setCurrentSequenceId(0000001L);
        unit.setCurrentSequenceTime(new Timestamp(new Date().getTime()));
        unit.setLocation(Location.A1);
        unit.setName("name");
        unit.setNumber("number");
        unit.setParentId(0000001L);
        unit.setPicNumber("picnumber");
        unit.setPicPath("picpath");
        unit.setUnitNumber("unitnumber");

        unitWriteRepository.save(unit);
        return new RestResult(Constants.STATE_SUCCESS, "",unit);
    }

    @Override
    @CachePut(key = "'unit_' +  #unitId")
    @CacheEvict(key = "'units'")
    public RestResult updateUnit(Long unitId) {
        Unit unit = unitReadRepository.findUnitById(unitId);

        unit.setCode("code");
        unit.setCurrentSequenceId(0000002L);
        unit.setCurrentSequenceTime(new Timestamp(new Date().getTime()));
        unit.setLocation(Location.A2);
        unit.setName("name");
        unit.setNumber("number");
        unit.setParentId(0000002L);
        unit.setPicNumber("picnumber");
        unit.setPicPath("picpath");
        unit.setUnitNumber("unitnumber");


        unitWriteRepository.save(unit);
        return new RestResult(Constants.STATE_SUCCESS, "",unit);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'units'"), @CacheEvict(key = "'unit_' +  #unitId") })
    public RestResult deleteUnit(Long unitId) {
        unitWriteRepository.deleteUnitById(unitId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'unit_' +  #unitId")
    public RestResult getUnitById(Long unitId) {
        return new RestResult(Constants.STATE_SUCCESS, "",unitReadRepository.findUnitById(unitId));
    }
}
