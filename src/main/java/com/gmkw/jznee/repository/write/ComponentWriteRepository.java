package com.gmkw.jznee.repository.write;

import com.gmkw.jznee.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentWriteRepository extends JpaRepository<Component, Long> {
    public Long deleteComponentById(Long componentId);
}
