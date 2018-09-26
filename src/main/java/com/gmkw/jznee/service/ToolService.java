package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface ToolService {
    public RestResult getTools();

//    public RestResult saveTool(String type, String warehouseBy, String location ,String picPath);
    public RestResult addTool(String number,String type,String warehouseBy,int location);

    public RestResult updateTool(String number, String receiveBy);

    public RestResult countByStatusIsTrue();

    @Transactional
    public RestResult deleteTool(Long toolId);

    public RestResult getToolById(Long toolId);

}
