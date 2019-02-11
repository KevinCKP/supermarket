package com.scau.kevin.supermarket.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Scrap {
    private Long scrapId;

    private Long goodsId;

    private Long staffId;

    private Date scrapTime;

    private BigDecimal scrapPrice;

    private Integer scrapNumber;

    private BigDecimal scrapTotal;

    private String scrapReason;

    private String scrapNote;

    private String staffName;

    private Byte scrapState;

    private Goods goods;

    public Long getScrapId() {
        return scrapId;
    }

    public void setScrapId(Long scrapId) {
        this.scrapId = scrapId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Date getScrapTime() {
        return scrapTime;
    }

    public void setScrapTime(Date scrapTime) {
        this.scrapTime = scrapTime;
    }

    public BigDecimal getScrapPrice() {
        return scrapPrice;
    }

    public void setScrapPrice(BigDecimal scrapPrice) {
        this.scrapPrice = scrapPrice;
    }

    public Integer getScrapNumber() {
        return scrapNumber;
    }

    public void setScrapNumber(Integer scrapNumber) {
        this.scrapNumber = scrapNumber;
    }

    public BigDecimal getScrapTotal() {
        return scrapTotal;
    }

    public void setScrapTotal(BigDecimal scrapTotal) {
        this.scrapTotal = scrapTotal;
    }

    public String getScrapReason() {
        return scrapReason;
    }

    public void setScrapReason(String scrapReason) {
        this.scrapReason = scrapReason;
    }

    public String getScrapNote() {
        return scrapNote;
    }

    public void setScrapNote(String scrapNote) {
        this.scrapNote = scrapNote;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Byte getScrapState() {
        return scrapState;
    }

    public void setScrapState(Byte scrapState) {
        this.scrapState = scrapState;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}