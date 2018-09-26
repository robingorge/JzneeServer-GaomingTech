package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.Tool;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.ToolReadRepository;
import com.gmkw.jznee.repository.write.ToolWriteRepository;
import com.gmkw.jznee.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "tools")
public class ToolServiceImpl  implements ToolService {
    @Autowired
    private ToolReadRepository toolReadRepository;

    @Autowired
    private ToolWriteRepository toolWriteRepository;


    @Override
    @Cacheable(key = "'tools'")
    public RestResult getTools() {
        return new RestResult(Constants.STATE_SUCCESS, "",toolReadRepository.findAll());
    }

    @Override
    @Cacheable(key = "'tools'")
    public RestResult countByStatusIsTrue(){
        return new RestResult(Constants.STATE_SUCCESS, "",toolReadRepository.countByStatusIsTrue());
    }

    @Override
    @CacheEvict(key = "'tools'")
//    public RestResult saveTool(String type, String warehouseBy, String location, String picPath) {
    public RestResult addTool(String number,String type,String warehouseBy,int location) {
        Tool tool = toolReadRepository.findToolByNumber(number);
        if (tool!=null){
            return new RestResult(Constants.STATE_FAIL, "",tool);
        }

        tool = new Tool();
        tool.setNumber(number);

        if (location==1) {
            tool.setLocation(Location.A2);
        }
        else if (location==2) {
            tool.setLocation(Location.B1);
        }
        else if (location==3) {
            tool.setLocation(Location.B2);
        }
        else {
            tool.setLocation(Location.A1);
        }

        tool.setStatus(true);
        tool.setPicPath("11111");
        tool.setWarehouseBy(warehouseBy);
        tool.setType(type);

        tool.setWarehouseTime(new Timestamp(new Date().getTime()));
        toolWriteRepository.save(tool);
        return new RestResult(Constants.STATE_SUCCESS, "",tool);
    }

    @Override
    @CachePut(key = "'tool_' +  #toolId")
    @CacheEvict(key = "'tools'")
    public RestResult updateTool(String number, String receiveBy) {
        Tool tool = toolReadRepository.findToolByNumber(number);
        if (tool==null){
            return new RestResult(Constants.STATE_FAIL, "",tool);
        }

        if (receiveBy.equals("no_receive_by")){
            tool.setStatus(false);
        }
        else{
            tool.setReceiveBy(receiveBy);
            tool.setReceiveTime(new Timestamp(new Date().getTime()));
        }

        toolWriteRepository.save(tool);
        return new RestResult(Constants.STATE_SUCCESS, "",tool);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'tools'"), @CacheEvict(key = "'tool_' +  #toolId") })
    public RestResult deleteTool(Long toolId) {
        toolWriteRepository.deleteToolById(toolId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'tool_' +  #toolId")
    public RestResult getToolById(Long toolId) {
        return new RestResult(Constants.STATE_SUCCESS, "",toolReadRepository.findToolById(toolId));
    }
}
