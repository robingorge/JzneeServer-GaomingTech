package com.gmkw.jznee.controller;

import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sequence")
public class SequenceController {

    @Autowired
    private SequenceService sequenceService;

    @RequestMapping(value = "/getSequences", method = {RequestMethod.POST})
    public RestResult getSequences(){
        return sequenceService.getSequences();
    }

    @RequestMapping(value = "/addSequence", method = {RequestMethod.POST})
    public RestResult addSequence(){
        return sequenceService.addSequence();
    }

    @RequestMapping(value = "/updateSequence", method = {RequestMethod.POST})
    public RestResult updateSequence(@RequestParam(value = "sequenceId") Long sequenceId){
        return sequenceService.updateSequence(sequenceId);
    }

    @RequestMapping(value = "/delSequence", method = {RequestMethod.POST})
    public RestResult delSequence(@RequestParam(value = "sequenceId") Long sequenceId){
        return sequenceService.deleteSequence(sequenceId);
    }

    @RequestMapping(value = "/getSequenceById", method = {RequestMethod.POST})
    public RestResult getSequenceById(@RequestParam(value = "sequenceId") Long sequenceId){
        return sequenceService.getSequenceById(sequenceId);
    }

}
