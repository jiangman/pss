package com.bysj.pss.model.pojo;

import java.util.Date;

public class MeterialOut {
    private Integer id;

    private Integer medicineProduceFk;

    private Integer meterialFk;

    private Double number;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicineProduceFk() {
        return medicineProduceFk;
    }

    public void setMedicineProduceFk(Integer medicineProduceFk) {
        this.medicineProduceFk = medicineProduceFk;
    }

    public Integer getMeterialFk() {
        return meterialFk;
    }

    public void setMeterialFk(Integer meterialFk) {
        this.meterialFk = meterialFk;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}