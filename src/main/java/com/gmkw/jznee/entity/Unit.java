package com.gmkw.jznee.entity;

import com.gmkw.jznee.constants.Location;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max=32)
    private String code;

    @Length(max=32)
    private String name;

    @Length(max=32)
    private String number;

    @Length(max=32)
    @Column(name = "pic_path")
    private String picPath;

    @Enumerated(value = EnumType.STRING)
    @Column(length=32, nullable=false)
    private Location location;

    @Length(max=32)
    @Column(name = "pic_number")
    private String picNumber;

    @Length(max=32)
    @Column(name = "unit_number")
    private String unitNumber;

    @Column(name="parent_id",columnDefinition="int(20)")
    private long parentId;

    @Column(name="current_sequence_id",columnDefinition="int(20)")
    private long currentSequenceId;

    @Column(name = "current_sequence_time" , columnDefinition="timestamp")
    private Timestamp currentSequenceTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(String picNumber) {
        this.picNumber = picNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getCurrentSequenceId() {
        return currentSequenceId;
    }

    public void setCurrentSequenceId(long currentSequenceId) {
        this.currentSequenceId = currentSequenceId;
    }

    public Timestamp getCurrentSequenceTime() {
        return currentSequenceTime;
    }

    public void setCurrentSequenceTime(Timestamp currentSequenceTime) {
        this.currentSequenceTime = currentSequenceTime;
    }
}
