package com.bysj.pss.model.pojo;

import java.util.Date;

public class MedicineProduce {
    private Integer id;

    private String medicineProduceId;

    private Integer medicineFk;

    private String produceMan;

    private Integer produceManFk;

    private Date createTime;

    private Integer num;

    private Integer saleNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineProduceId() {
        return medicineProduceId;
    }

    public void setMedicineProduceId(String medicineProduceId) {
        this.medicineProduceId = medicineProduceId == null ? null : medicineProduceId.trim();
    }

    public Integer getMedicineFk() {
        return medicineFk;
    }

    public void setMedicineFk(Integer medicineFk) {
        this.medicineFk = medicineFk;
    }

    public String getProduceMan() {
        return produceMan;
    }

    public void setProduceMan(String produceMan) {
        this.produceMan = produceMan == null ? null : produceMan.trim();
    }

    public Integer getProduceManFk() {
        return produceManFk;
    }

    public void setProduceManFk(Integer produceManFk) {
        this.produceManFk = produceManFk;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }
}