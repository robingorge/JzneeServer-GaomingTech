package com.gmkw.jznee.repository.write;

import com.gmkw.jznee.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitWriteRepository extends JpaRepository<Unit, Long> {
    public Long deleteUnitById(Long unitId);
}
