package com.bysj.pss.model.pojo;

public class Medicine {
    private Integer id;

    private String medicineName;

    private String medicineOtherName;

    private String licenseNo;

    private Double tradePrice;

    private Double retailPrice;

    private Integer sizeNum;

    private String size;

    private String saveway;

    private Byte validityPeriod;

    private String picturePath;

    private String introduce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    public String getMedicineOtherName() {
        return medicineOtherName;
    }

    public void setMedicineOtherName(String medicineOtherName) {
        this.medicineOtherName = medicineOtherName == null ? null : medicineOtherName.trim();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getSizeNum() {
        return sizeNum;
    }

    public void setSizeNum(Integer sizeNum) {
        this.sizeNum = sizeNum;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getSaveway() {
        return saveway;
    }

    public void setSaveway(String saveway) {
        this.saveway = saveway == null ? null : saveway.trim();
    }

    public Byte getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Byte validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}