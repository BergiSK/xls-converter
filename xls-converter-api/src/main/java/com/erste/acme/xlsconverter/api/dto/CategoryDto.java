package com.erste.acme.xlsconverter.api.dto;

public class CategoryDto {

    private int limitBottom;
    private int limitTop;
    private double fee;
    private String name;

    public int getLimitBottom() {
        return limitBottom;
    }

    public void setLimitBottom(int limitBottom) {
        this.limitBottom = limitBottom;
    }

    public int getLimitTop() {
        return limitTop;
    }

    public void setLimitTop(int limitTop) {
        this.limitTop = limitTop;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
