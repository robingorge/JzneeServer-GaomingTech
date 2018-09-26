package com.gmkw.jznee.service;

import com.gmkw.jznee.model.RestResult;
import org.springframework.transaction.annotation.Transactional;

public interface SequenceService {
    public RestResult getSequences();

    //    public RestResult saveSequence(String type, String warehouseBy, String location ,String picPath);
    public RestResult addSequence();

    public RestResult updateSequence(Long sequenceId);

    @Transactional
    public RestResult deleteSequence(Long sequenceId);

    public RestResult getSequenceById(Long sequenceId);
}
