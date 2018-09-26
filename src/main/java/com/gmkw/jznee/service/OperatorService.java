package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface OperatorService {
    public RestResult getOperators();

    //    public RestResult saveOperator(String type, String warehouseBy, String location ,String picPath);
    public RestResult addOperator();

    public RestResult updateOperator(Long operatorId);

    @Transactional
    public RestResult deleteOperator(Long operatorId);

    public RestResult getOperatorById(Long operatorId);
}
