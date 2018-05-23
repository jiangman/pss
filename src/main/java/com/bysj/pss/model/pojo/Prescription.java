package com.bysj.pss.model.pojo;

public class Prescription {
    private Integer id;

    private Integer medicineFk;

    private Integer meterialFk;

    private Double num;

    private Byte size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicineFk() {
        return medicineFk;
    }

    public void setMedicineFk(Integer medicineFk) {
        this.medicineFk = medicineFk;
    }

    public Integer getMeterialFk() {
        return meterialFk;
    }

    public void setMeterialFk(Integer meterialFk) {
        this.meterialFk = meterialFk;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }
}