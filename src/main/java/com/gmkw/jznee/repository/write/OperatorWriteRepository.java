package com.gmkw.jznee.repository.write;

import com.gmkw.jznee.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorWriteRepository extends JpaRepository<Operator, Long> {
    public Long deleteOperatorById(Long operatorId);
}
