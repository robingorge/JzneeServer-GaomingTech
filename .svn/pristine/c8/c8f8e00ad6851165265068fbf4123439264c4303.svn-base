package com.gmkw.jznee.service;
import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;


public interface WarningService {
    public RestResult getWarnings();

    //    public RestResult saveWarning(String type, String warehouseBy, String location ,String picPath);
    public RestResult addWarning();

    public RestResult updateWarning(Long warningId,String result);

    @Transactional
    public RestResult deleteWarning(Long warningId);

    public RestResult getWarningById(Long warningId);
}
