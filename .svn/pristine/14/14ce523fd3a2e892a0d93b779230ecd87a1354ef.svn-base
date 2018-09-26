package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.Operator;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.OperatorReadRepository;
import com.gmkw.jznee.repository.write.OperatorWriteRepository;
import com.gmkw.jznee.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "operators")
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorReadRepository operatorReadRepository;

    @Autowired
    private OperatorWriteRepository operatorWriteRepository;


    @Override
    @Cacheable(key = "'operators'")
    public RestResult getOperators() {
        return new RestResult(Constants.STATE_SUCCESS, "",operatorReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'operators'")
//    public RestResult saveOperator(String type, String warehouseBy, String location, String picPath) {
    public RestResult addOperator() {
        Operator operator = new Operator();

        operator.setJob("test1");
        operator.setName("test1");
        operator.setNumber("test1");
        operator.setSuperiorId(1234567890L);
        operator.setSuperiorName("test1");

        operatorWriteRepository.save(operator);
        return new RestResult(Constants.STATE_SUCCESS, "",operator);
    }

    @Override
    @CachePut(key = "'operator_' +  #operatorId")
    @CacheEvict(key = "'operators'")
    public RestResult updateOperator(Long operatorId) {
        Operator operator = operatorReadRepository.findOperatorById(operatorId);

        operator.setJob("test2");
        operator.setName("test2");
        operator.setNumber("test2");
        operator.setSuperiorId(1234567890L);
        operator.setSuperiorName("test2");

        operatorWriteRepository.save(operator);
        return new RestResult(Constants.STATE_SUCCESS, "",operator);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'operators'"), @CacheEvict(key = "'operator_' +  #operatorId") })
    public RestResult deleteOperator(Long operatorId) {
        operatorWriteRepository.deleteOperatorById(operatorId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'operator_' +  #operatorId")
    public RestResult getOperatorById(Long operatorId) {
        return new RestResult(Constants.STATE_SUCCESS, "",operatorReadRepository.findOperatorById(operatorId));
    }
}
