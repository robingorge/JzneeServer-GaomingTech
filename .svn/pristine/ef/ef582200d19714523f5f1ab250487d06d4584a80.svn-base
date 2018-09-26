package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.Warning;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.WarningReadRepository;
import com.gmkw.jznee.repository.write.WarningWriteRepository;
import com.gmkw.jznee.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "warnings")
public class WarningServiceImpl implements WarningService {
    @Autowired
    private WarningReadRepository warningReadRepository;

    @Autowired
    private WarningWriteRepository warningWriteRepository;


    @Override
    @Cacheable(key = "'warnings'")
    public RestResult getWarnings() {
        return new RestResult(Constants.STATE_SUCCESS, "",warningReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'warnings'")
//    public RestResult saveWarning(String type, String warehouseBy, String location, String picPath) {
    public RestResult addWarning() {
        Warning warning = new Warning();

        warning.setComponentCode("testtest");
        warning.setContent("testtest");
        warning.setLocation(Location.A1);
        warning.setResult("testtest");
        warning.setStatus(true);
        warning.setTime(new Timestamp(new Date().getTime()));
        warning.setType(678910L);
        warning.setUnitCode("testtest");

        warningWriteRepository.save(warning);
        return new RestResult(Constants.STATE_SUCCESS, "",warning);
    }

    @Override
    @CachePut(key = "'warning_' +  #warningId")
    @CacheEvict(key = "'warnings'")
    public RestResult updateWarning(Long warningId,String result) {
        Warning warning = warningReadRepository.findWarningById(warningId);

//        warning.setComponentCode("testtestaddd");
//        warning.setContent("testtest");
//        warning.setLocation(Location.A2);
        warning.setResult(result);
        warning.setStatus(false);
        warning.setTime(new Timestamp(new Date().getTime()));
//        warning.setType(678910L);
//        warning.setUnitCode("testtest");

        warningWriteRepository.save(warning);
        return new RestResult(Constants.STATE_SUCCESS, "",warning);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'warnings'"), @CacheEvict(key = "'warning_' +  #warningId") })
    public RestResult deleteWarning(Long warningId) {
        warningWriteRepository.deleteWarningById(warningId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'warning_' +  #warningId")
    public RestResult getWarningById(Long warningId) {
        return new RestResult(Constants.STATE_SUCCESS, "",warningReadRepository.findWarningById(warningId));
    }
}
