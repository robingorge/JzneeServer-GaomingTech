package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping(value = "/getOperators", method = {RequestMethod.POST})
    public RestResult getOperators(){
        return operatorService.getOperators();
    }

    @RequestMapping(value = "/addOperator", method = {RequestMethod.POST})
    public RestResult addOperator(){
        return operatorService.addOperator();
    }

    @RequestMapping(value = "/updateOperator", method = {RequestMethod.POST})
    public RestResult updateOperator(@RequestParam(value = "operatorId") Long operatorId){
        return operatorService.updateOperator(operatorId);
    }

    @RequestMapping(value = "/delOperator", method = {RequestMethod.POST})
    public RestResult delOperator(@RequestParam(value = "operatorId") Long operatorId){
        return operatorService.deleteOperator(operatorId);
    }

    @RequestMapping(value = "/getOperatorById", method = {RequestMethod.POST})
    public RestResult getOperatorById(@RequestParam(value = "operatorId") Long operatorId){
        return operatorService.getOperatorById(operatorId);
    }

}
