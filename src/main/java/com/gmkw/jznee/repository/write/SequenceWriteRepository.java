package com.gmkw.jznee.repository.write;

import com.gmkw.jznee.entity.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceWriteRepository extends JpaRepository<Sequence, Long> {
    public Long deleteSequenceById(Long sequenceId);
}
