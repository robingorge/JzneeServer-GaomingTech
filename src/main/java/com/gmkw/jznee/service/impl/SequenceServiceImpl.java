package com.gmkw.jznee.service.impl;

import com.gmkw.jznee.constants.Constants;
import com.gmkw.jznee.constants.Location;
import com.gmkw.jznee.entity.Sequence;
import com.gmkw.jznee.model.RestResult;
import com.gmkw.jznee.repository.read.SequenceReadRepository;
import com.gmkw.jznee.repository.write.SequenceWriteRepository;
import com.gmkw.jznee.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@CacheConfig(cacheNames = "sequences")
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    private SequenceReadRepository sequenceReadRepository;

    @Autowired
    private SequenceWriteRepository sequenceWriteRepository;


    @Override
    @Cacheable(key = "'sequences'")
    public RestResult getSequences() {
        return new RestResult(Constants.STATE_SUCCESS, "",sequenceReadRepository.findAll());
    }

    @Override
    @CacheEvict(key = "'sequences'")
//    public RestResult saveSequence(String type, String warehouseBy, String location, String picPath) {
    public RestResult addSequence() {
        Sequence sequence = new Sequence();

        sequence.setComponentCode("componentcode01");
        sequence.setDeviceId(011110001L);
        sequence.setDeviceName("devicename01");
        sequence.setName("name02");
        sequence.setOperator("operator01");
        sequence.setTime(new Timestamp(new Date().getTime()));
        sequence.setUnitCode("unitcode");
        sequence.setOperatorId(0101011L);

        sequenceWriteRepository.save(sequence);
        return new RestResult(Constants.STATE_SUCCESS, "",sequence);
    }

    @Override
    @CachePut(key = "'sequence_' +  #sequenceId")
    @CacheEvict(key = "'sequences'")
    public RestResult updateSequence(Long sequenceId) {
        Sequence sequence = sequenceReadRepository.findSequenceById(sequenceId);

        sequence.setComponentCode("componentcode02");
        sequence.setDeviceId(011110001L);
        sequence.setDeviceName("devicename02");
        sequence.setName("name02");
        sequence.setOperator("operator02");
        sequence.setTime(new Timestamp(new Date().getTime()));
        sequence.setUnitCode("unitcode");
        sequence.setOperatorId(0101011L);

        sequenceWriteRepository.save(sequence);
        return new RestResult(Constants.STATE_SUCCESS, "",sequence);
    }

    @Override
    @Caching(evict = { @CacheEvict(key = "'sequences'"), @CacheEvict(key = "'sequence_' +  #sequenceId") })
    public RestResult deleteSequence(Long sequenceId) {
        sequenceWriteRepository.deleteSequenceById(sequenceId);
        return new RestResult(Constants.STATE_SUCCESS, "");
    }

    @Override
    @Cacheable(key = "'sequence_' +  #sequenceId")
    public RestResult getSequenceById(Long sequenceId) {
        return new RestResult(Constants.STATE_SUCCESS, "",sequenceReadRepository.findSequenceById(sequenceId));
    }
}
