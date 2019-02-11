package com.scau.kevin.supermarket.entity;

import java.util.Date;

public class Goodsstock {
    private Long gsId;

    private Long goodsId;

    private String gsAddress;

    private Integer gsNumber;

    private Integer gsWarnnumber;

    private String gsNote;

    private Date gsUpdateTime;

    private Goods goods;

    public Long getGsId() {
        return gsId;
    }

    public void setGsId(Long gsId) {
        this.gsId = gsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGsAddress() {
        return gsAddress;
    }

    public void setGsAddress(String gsAddress) {
        this.gsAddress = gsAddress;
    }

    public Integer getGsNumber() {
        return gsNumber;
    }

    public void setGsNumber(Integer gsNumber) {
        this.gsNumber = gsNumber;
    }

    public Integer getGsWarnnumber() {
        return gsWarnnumber;
    }

    public void setGsWarnnumber(Integer gsWarnnumber) {
        this.gsWarnnumber = gsWarnnumber;
    }

    public String getGsNote() {
        return gsNote;
    }

    public void setGsNote(String gsNote) {
        this.gsNote = gsNote;
    }

    public Date getGsUpdateTime() {
        return gsUpdateTime;
    }

    public void setGsUpdateTime(Date gsUpdateTime) {
        this.gsUpdateTime = gsUpdateTime;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}