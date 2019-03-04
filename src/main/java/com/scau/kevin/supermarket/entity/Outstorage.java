package com.scau.kevin.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Outstorage {
    private Long osId;

    private Long osOperatorId;

    private String osOperatorName;

    private Long goodsId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date osDate;

    private Integer osNumber;

    private Integer osLeftnumber;

    private BigDecimal osMoney;

    private String osDestination;

    private String osNote;

    private Goods goods;

    public Long getOsId() {
        return osId;
    }

    public void setOsId(Long osId) {
        this.osId = osId;
    }

    public Long getOsOperatorId() {
        return osOperatorId;
    }

    public void setOsOperatorId(Long osOperatorId) {
        this.osOperatorId = osOperatorId;
    }

    public String getOsOperatorName() {
        return osOperatorName;
    }

    public void setOsOperatorName(String osOperatorName) {
        this.osOperatorName = osOperatorName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getOsDate() {
        return osDate;
    }

    public void setOsDate(Date osDate) {
        this.osDate = osDate;
    }

    public Integer getOsNumber() {
        return osNumber;
    }

    public void setOsNumber(Integer osNumber) {
        this.osNumber = osNumber;
    }

    public Integer getOsLeftnumber() {
        return osLeftnumber;
    }

    public void setOsLeftnumber(Integer osLeftnumber) {
        this.osLeftnumber = osLeftnumber;
    }

    public BigDecimal getOsMoney() {
        return osMoney;
    }

    public void setOsMoney(BigDecimal osMoney) {
        this.osMoney = osMoney;
    }

    public String getOsDestination() {
        return osDestination;
    }

    public void setOsDestination(String osDestination) {
        this.osDestination = osDestination;
    }

    public String getOsNote() {
        return osNote;
    }

    public void setOsNote(String osNote) {
        this.osNote = osNote;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}