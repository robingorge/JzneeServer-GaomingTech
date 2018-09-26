package com.gmkw.jznee.repository.read;

import com.gmkw.jznee.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolReadRepository extends JpaRepository<Tool, Long> {
    public Tool findToolById(Long toolId);

    public Tool findToolByNumber(String number);

    public Long countByStatusIsTrue();

}
