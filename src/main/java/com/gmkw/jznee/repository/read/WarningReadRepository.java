package com.gmkw.jznee.repository.read;

import com.gmkw.jznee.entity.Warning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarningReadRepository extends JpaRepository<Warning, Long> {
    public Warning findWarningById(Long warningId);

}
