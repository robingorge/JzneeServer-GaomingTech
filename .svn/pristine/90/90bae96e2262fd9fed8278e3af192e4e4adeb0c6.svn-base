package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/getUnits", method = {RequestMethod.POST})
    public RestResult getUnits(){
        return unitService.getUnits();
    }

    @RequestMapping(value = "/addUnit", method = {RequestMethod.POST})
    public RestResult addUnit(){
        return unitService.addUnit();
    }

    @RequestMapping(value = "/updateUnit", method = {RequestMethod.POST})
    public RestResult updateUnit(@RequestParam(value = "unitId") Long unitId){
        return unitService.updateUnit(unitId);
    }

    @RequestMapping(value = "/delUnit", method = {RequestMethod.POST})
    public RestResult delUnit(@RequestParam(value = "unitId") Long unitId){
        return unitService.deleteUnit(unitId);
    }

    @RequestMapping(value = "/getUnitById", method = {RequestMethod.POST})
    public RestResult getUnitById(@RequestParam(value = "unitId") Long unitId){
        return unitService.getUnitById(unitId);
    }

}
