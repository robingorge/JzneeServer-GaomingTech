package com.gmkw.jznee.entity;

import com.gmkw.jznee.constants.Location;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="component")
public class Component implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max=32)
    private String code;

    @Length(max=32)
    private String material;

    @Length(max=32)
    private String specification;

    @Length(max=32)
    private String supplier;

    @Length(max=32)
    private String name;

    @Length(max=32)
    private String number;

    @Length(max=32)
    @Column(name = "component_number")
    private String componentNumber;

    @Length(max=32)
    @Column(name = "pic_path")
    private String picPath;

    @Length(max=32)
    @Column(name = "batch_number")
    private String batchNumber;

    @Length(max=32)
    @Column(name = "pic_number")
    private String picNumber;

    @Length(max=32)
    @Column(name = "purchase_number")
    private String purchaseNumber;

    @Length(max=32)
    @Column(name = "purchase_name")
    private String purchaseName;

    @Enumerated(value = EnumType.STRING)
    @Column(length=32, nullable=false)
    private Location location;

    @Column(name="parent_id",columnDefinition="int(20)")
    private long parentId;

    @Column(name="purchase_id",columnDefinition="int(20)")
    private long purchaseId;


    @Column(name = "purchase_time" , columnDefinition="timestamp")
    private Timestamp purchaseTime;

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

    public String getComponentNumber() {
        return componentNumber;
    }

    public void setComponentNumber(String componentNumber) {
        this.componentNumber = componentNumber;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(String picNumber) {
        this.picNumber = picNumber;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getPurchaseName() {
        return purchaseName;
    }

    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Timestamp purchaseTime) {
        this.purchaseTime = purchaseTime;
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
