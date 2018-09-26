package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/warning")
public class WarningController {

    @Autowired
    private WarningService warningService;

    @RequestMapping(value = "/getWarnings", method = {RequestMethod.POST})
    public RestResult getWarnings(){
        return warningService.getWarnings();
    }

    @RequestMapping(value = "/addWarning", method = {RequestMethod.POST})
    public RestResult addWarning(){
        return warningService.addWarning();
    }

    @RequestMapping(value = "/updateWarning", method = {RequestMethod.POST})
    public RestResult updateWarning(@RequestParam(value = "warningId") Long warningId, @RequestParam(value = "result") String result){
        return warningService.updateWarning(warningId,result);
    }

    @RequestMapping(value = "/delWarning", method = {RequestMethod.POST})
    public RestResult delWarning(@RequestParam(value = "warningId") Long warningId){
        return warningService.deleteWarning(warningId);
    }

    @RequestMapping(value = "/getWarningById", method = {RequestMethod.POST})
    public RestResult getWarningById(@RequestParam(value = "warningId") Long warningId){
        return warningService.getWarningById(warningId);
    }

}
