package com.scau.kevin.supermarket.entity;

import java.math.BigDecimal;

public class Buydetail {
    private Long bdId;

    private Long goodsId;

    private Long boId;

    private Integer bdNumber;

    private BigDecimal bdPrice;

    private BigDecimal bdTotal;

    private String bdNote;

    private Byte bdState;

    private Integer bdInNumber;

    private Goods goods;

    public Long getBdId() {
        return bdId;
    }

    public void setBdId(Long bdId) {
        this.bdId = bdId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Integer getBdNumber() {
        return bdNumber;
    }

    public void setBdNumber(Integer bdNumber) {
        this.bdNumber = bdNumber;
    }

    public BigDecimal getBdPrice() {
        return bdPrice;
    }

    public void setBdPrice(BigDecimal bdPrice) {
        this.bdPrice = bdPrice;
    }

    public BigDecimal getBdTotal() {
        return bdTotal;
    }

    public void setBdTotal(BigDecimal bdTotal) {
        this.bdTotal = bdTotal;
    }

    public String getBdNote() {
        return bdNote;
    }

    public void setBdNote(String bdNote) {
        this.bdNote = bdNote;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getBdInNumber() {
        return bdInNumber;
    }

    public void setBdInNumber(Integer bdInNumber) {
        this.bdInNumber = bdInNumber;
    }

    public Byte getBdState() {
        return bdState;
    }

    public void setBdState(Byte bdState) {
        this.bdState = bdState;
    }
}