package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tool")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @RequestMapping(value = "/getTools", method = {RequestMethod.POST})
    public RestResult getTools(){
        return toolService.getTools();
    }

    @RequestMapping(value = "/countByStatusIsTrue", method = {RequestMethod.POST})
    public RestResult countByStatusIsTrue(){
        return toolService.countByStatusIsTrue();
    }

    @RequestMapping(value = "/addTool", method = {RequestMethod.POST})
    public RestResult addTool(@RequestParam(value = "number") String number,@RequestParam(value = "type") String type,@RequestParam(value = "warehouseBy") String warehouseBy,@RequestParam(value = "location") int location){
        return toolService.addTool(number,type,warehouseBy,location);
    }

    @RequestMapping(value = "/updateTool", method = {RequestMethod.POST})
    public RestResult updateTool(@RequestParam(value = "number") String number,@RequestParam(value = "receiveBy") String receiveBy ){
        return toolService.updateTool(number,receiveBy);
    }

    @RequestMapping(value = "/delTool", method = {RequestMethod.POST})
    public RestResult delTool(@RequestParam(value = "toolId") Long toolId){
        return toolService.deleteTool(toolId);
    }

    @RequestMapping(value = "/getToolById", method = {RequestMethod.POST})
    public RestResult getToolById(@RequestParam(value = "toolId") Long toolId){
        return toolService.getToolById(toolId);
    }

}
