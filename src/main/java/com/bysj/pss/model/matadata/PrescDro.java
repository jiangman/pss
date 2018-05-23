package com.bysj.pss.model.matadata;

public class PrescDro {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getNeed() {
        return need;
    }

    public void setNeed(Double need) {
        this.need = need;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private Integer id;
    private String name;
    private Double number;
    private Double need;
    private String size;

    public Double getUnitNeed() {
        return unitNeed;
    }

    public void setUnitNeed(Double unitNeed) {
        this.unitNeed = unitNeed;
    }

    private Double unitNeed;
}
