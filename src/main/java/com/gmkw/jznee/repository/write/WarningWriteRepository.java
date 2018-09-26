package com.gmkw.jznee.repository.write;

import com.gmkw.jznee.entity.Warning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarningWriteRepository extends JpaRepository<Warning, Long> {
    public Long deleteWarningById(Long warningId);
}
