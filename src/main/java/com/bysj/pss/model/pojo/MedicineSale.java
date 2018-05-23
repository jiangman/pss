package com.bysj.pss.model.pojo;

import java.util.Date;

public class MedicineSale {
    private Integer id;

    private Integer enterpirsId;

    private String medicineProduceFk;

    private Integer num;

    private String saleMale;

    private Integer saleMaleFk;

    private String contractCode;

    private String deliveryAddress;

    private Byte ransportType;

    private Byte status;

    private Date deliveryDate;

    private Date successDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnterpirsId() {
        return enterpirsId;
    }

    public void setEnterpirsId(Integer enterpirsId) {
        this.enterpirsId = enterpirsId;
    }

    public String getMedicineProduceFk() {
        return medicineProduceFk;
    }

    public void setMedicineProduceFk(String medicineProduceFk) {
        this.medicineProduceFk = medicineProduceFk == null ? null : medicineProduceFk.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSaleMale() {
        return saleMale;
    }

    public void setSaleMale(String saleMale) {
        this.saleMale = saleMale == null ? null : saleMale.trim();
    }

    public Integer getSaleMaleFk() {
        return saleMaleFk;
    }

    public void setSaleMaleFk(Integer saleMaleFk) {
        this.saleMaleFk = saleMaleFk;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public Byte getRansportType() {
        return ransportType;
    }

    public void setRansportType(Byte ransportType) {
        this.ransportType = ransportType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(Date successDate) {
        this.successDate = successDate;
    }
}