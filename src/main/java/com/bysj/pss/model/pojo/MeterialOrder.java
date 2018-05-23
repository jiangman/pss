package com.bysj.pss.model.pojo;

import java.util.Date;

public class MeterialOrder {
    private Integer id;

    private Integer meterialFk;

    private Integer enterpriseId;

    private Date operationDate;

    private String serialNo;

    private Integer salesman;

    private Double unitPrice;

    private Double number;

    private Byte size;

    private String sremark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeterialFk() {
        return meterialFk;
    }

    public void setMeterialFk(Integer meterialFk) {
        this.meterialFk = meterialFk;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Integer getSalesman() {
        return salesman;
    }

    public void setSalesman(Integer salesman) {
        this.salesman = salesman;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark == null ? null : sremark.trim();
    }
}