package com.scau.kevin.supermarket.entity;

import java.math.BigDecimal;

public class Buyreturndetail {
    private Long brdId;

    private Long brdGoodsId;

    private Long brId;

    private Integer brdNumber;

    private BigDecimal brdPrice;

    private BigDecimal brdTotal;

    private String brdReason;

    private Byte brdState;

    private Integer brdActualNumber;

    private Byte brdHandlingWay;

    private String brdNote;

    private Goods goods;

    public Long getBrdId() {
        return brdId;
    }

    public void setBrdId(Long brdId) {
        this.brdId = brdId;
    }

    public Long getBrdGoodsId() {
        return brdGoodsId;
    }

    public void setBrdGoodsId(Long brdGoodsId) {
        this.brdGoodsId = brdGoodsId;
    }

    public Long getBrId() {
        return brId;
    }

    public void setBrId(Long brId) {
        this.brId = brId;
    }

    public Integer getBrdNumber() {
        return brdNumber;
    }

    public void setBrdNumber(Integer brdNumber) {
        this.brdNumber = brdNumber;
    }

    public BigDecimal getBrdPrice() {
        return brdPrice;
    }

    public void setBrdPrice(BigDecimal brdPrice) {
        this.brdPrice = brdPrice;
    }

    public BigDecimal getBrdTotal() {
        return brdTotal;
    }

    public void setBrdTotal(BigDecimal brdTotal) {
        this.brdTotal = brdTotal;
    }

    public String getBrdReason() {
        return brdReason;
    }

    public void setBrdReason(String brdReason) {
        this.brdReason = brdReason;
    }

    public Byte getBrdState() {
        return brdState;
    }

    public void setBrdState(Byte brdState) {
        this.brdState = brdState;
    }

    public Integer getBrdActualNumber() {
        return brdActualNumber;
    }

    public void setBrdActualNumber(Integer brdActualNumber) {
        this.brdActualNumber = brdActualNumber;
    }

    public Byte getBrdHandlingWay() {
        return brdHandlingWay;
    }

    public void setBrdHandlingWay(Byte brdHandlingWay) {
        this.brdHandlingWay = brdHandlingWay;
    }

    public String getBrdNote() {
        return brdNote;
    }

    public void setBrdNote(String brdNote) {
        this.brdNote = brdNote;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}