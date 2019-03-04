package com.scau.kevin.supermarket.dto;

/**
 * @Author: kevin
 * @Date: 2019/2/28 20:45
 * @Version 1.0
 */
public class QueryDto {

    private String beginTime;


    private String endTime;


    private String factor;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }
}
