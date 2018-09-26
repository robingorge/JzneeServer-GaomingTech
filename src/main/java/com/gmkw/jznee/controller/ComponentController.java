package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/component")
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @RequestMapping(value = "/getComponents", method = {RequestMethod.POST})
    public RestResult getComponents(){
        return componentService.getComponents();
    }

    @RequestMapping(value = "/addComponent", method = {RequestMethod.POST})
    public RestResult addComponent(){
        return componentService.addComponent();
    }

    @RequestMapping(value = "/updateComponent", method = {RequestMethod.POST})
    public RestResult updateComponent(@RequestParam(value = "componentId") Long componentId){
        return componentService.updateComponent(componentId);
    }

    @RequestMapping(value = "/delComponent", method = {RequestMethod.POST})
    public RestResult delComponent(@RequestParam(value = "componentId") Long componentId){
        return componentService.deleteComponent(componentId);
    }

    @RequestMapping(value = "/getComponentById", method = {RequestMethod.POST})
    public RestResult getComponentById(@RequestParam(value = "componentId") Long componentId){
        return componentService.getComponentById(componentId);
    }

}
