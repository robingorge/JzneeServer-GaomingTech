package com.gmkw.jznee.entity;

import com.gmkw.jznee.constants.Location;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="tool")
public class Tool implements Serializable {

    private static final long serialVersionUID = -6078348922844222353L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length=32, nullable=false)
    private String number;


    @Length(max=32)
    private String type;

    @Length(max=32)
    @Column(name = "warehouse_by")
    private String warehouseBy;

    @Column(name = "warehouse_time" , columnDefinition="timestamp")
    private Timestamp warehouseTime;


    @Enumerated(value = EnumType.STRING)
    @Column(length=32, nullable=false)
    private Location location;

    @Column(columnDefinition="tinyint(1)")
    private Boolean status;

    @Length(max=32)
    @Column(name = "receive_by")
    private String receiveBy;

    @Column(name = "receive_time" , columnDefinition="timestamp")
    private Timestamp receiveTime;

    @Length(max=32)
    @Column(name = "pic_path")
    private String picPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWarehouseBy() {
        return warehouseBy;
    }

    public void setWarehouseBy(String warehouseBy) {
        this.warehouseBy = warehouseBy;
    }

    public Timestamp getWarehouseTime() {
        return warehouseTime;
    }

    public void setWarehouseTime(Timestamp warehouseTime) {
        this.warehouseTime = warehouseTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(String receiveBy) {
        this.receiveBy = receiveBy;
    }

    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
