package com.scau.kevin.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Instorage {
    private Long isId;

    private Long boId;

    private Long isOperatorId;

    private Long goodsId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date isTime;

    private Integer isNumber;

    private Integer isAfternumber;

    private String isNote;

    private String isOperatorName;

    private BigDecimal isGoodsPrice;

    private BigDecimal isGoodsTotal;

    private Goods goods;

    public Long getIsId() {
        return isId;
    }

    public void setIsId(Long isId) {
        this.isId = isId;
    }

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Long getIsOperatorId() {
        return isOperatorId;
    }

    public void setIsOperatorId(Long isOperatorId) {
        this.isOperatorId = isOperatorId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getIsTime() {
        return isTime;
    }

    public void setIsTime(Date isTime) {
        this.isTime = isTime;
    }

    public Integer getIsNumber() {
        return isNumber;
    }

    public void setIsNumber(Integer isNumber) {
        this.isNumber = isNumber;
    }

    public Integer getIsAfternumber() {
        return isAfternumber;
    }

    public void setIsAfternumber(Integer isAfternumber) {
        this.isAfternumber = isAfternumber;
    }

    public String getIsNote() {
        return isNote;
    }

    public void setIsNote(String isNote) {
        this.isNote = isNote;
    }

    public String getIsOperatorName() {
        return isOperatorName;
    }

    public void setIsOperatorName(String isOperatorName) {
        this.isOperatorName = isOperatorName;
    }

    public BigDecimal getIsGoodsPrice() {
        return isGoodsPrice;
    }

    public void setIsGoodsPrice(BigDecimal isGoodsPrice) {
        this.isGoodsPrice = isGoodsPrice;
    }

    public BigDecimal getIsGoodsTotal() {
        return isGoodsTotal;
    }

    public void setIsGoodsTotal(BigDecimal isGoodsTotal) {
        this.isGoodsTotal = isGoodsTotal;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}