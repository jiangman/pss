package com.bysj.pss.model.matadata;

public class MeterialMetadata {
    private Integer id;

    private String meterialName;

    private String meterialOtherName;

    public String getMeterialSize() {
        return meterialSize;
    }

    public void setMeterialSize(String meterialSize) {
        this.meterialSize = meterialSize;
    }

    private String meterialSize;

    private String saveway;

    private Integer enterpriseId;

    private Double number;

    private Double numberNeed;

    private String picturePath;

    private String introduce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeterialName() {
        return meterialName;
    }

    public void setMeterialName(String meterialName) {
        this.meterialName = meterialName;
    }

    public String getMeterialOtherName() {
        return meterialOtherName;
    }

    public void setMeterialOtherName(String meterialOtherName) {
        this.meterialOtherName = meterialOtherName;
    }

    public String getSaveway() {
        return saveway;
    }

    public void setSaveway(String saveway) {
        this.saveway = saveway;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getNumberNeed() {
        return numberNeed;
    }

    public void setNumberNeed(Double numberNeed) {
        this.numberNeed = numberNeed;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
