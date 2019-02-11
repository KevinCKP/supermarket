package com.scau.kevin.supermarket.entity;

import java.math.BigDecimal;

public class Saledetail {
    private Long sdId;

    private Long srId;

    private Long goodsId;

    private Integer sdNumber;

    private BigDecimal sdPrice;

    private BigDecimal sdTotal;

    private BigDecimal sdProfit;

    private Goods goods;

    public Long getSdId() {
        return sdId;
    }

    public void setSdId(Long sdId) {
        this.sdId = sdId;
    }

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSdNumber() {
        return sdNumber;
    }

    public void setSdNumber(Integer sdNumber) {
        this.sdNumber = sdNumber;
    }

    public BigDecimal getSdPrice() {
        return sdPrice;
    }

    public void setSdPrice(BigDecimal sdPrice) {
        this.sdPrice = sdPrice;
    }

    public BigDecimal getSdTotal() {
        return sdTotal;
    }

    public void setSdTotal(BigDecimal sdTotal) {
        this.sdTotal = sdTotal;
    }

    public BigDecimal getSdProfit() {
        return sdProfit;
    }

    public void setSdProfit(BigDecimal sdProfit) {
        this.sdProfit = sdProfit;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}