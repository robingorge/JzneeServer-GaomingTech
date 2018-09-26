package com.gmkw.jznee.entity;


import com.gmkw.jznee.constants.Location;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="warning")
public class Warning implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="int(11)")
    private Long type;

    @Length(max=32)
    private String content;

    @Length(max=32)
    @Column(name = "component_code")
    private String componentCode;

    @Length(max=32)
    @Column(name = "unit_code")
    private String unitCode;


    @Column(columnDefinition="timestamp")
    private Timestamp time;


    @Column(columnDefinition="tinyint(1)")
    private Boolean status;

    @Enumerated(value = EnumType.STRING)
    @Column(length=32, nullable=false)
    private Location location;

    @Length(max=32)
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
