package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface UnitService {
    public RestResult getUnits();

    //    public RestResult saveUnit(String type, String warehouseBy, String location ,String picPath);
    public RestResult addUnit();

    public RestResult updateUnit(Long unitId);

    @Transactional
    public RestResult deleteUnit(Long unitId);

    public RestResult getUnitById(Long unitId);
}
