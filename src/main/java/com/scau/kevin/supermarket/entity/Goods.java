package com.scau.kevin.supermarket.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Long goodsId;

    private Long categoryId;

    private Long supplierId;

    private String goodsName;

    private String goodsBarcode;

    private BigDecimal goodsSaleprice;

    private String goodsSpecification;

    private String goodsMetricunit;

    private BigDecimal goodsBuyprice;

    private BigDecimal goodsMemprice;

    private String goodsDestination;

    private String goodsProduceplace;

    private String goodsCategory;

    private String goodsSupplier;

    private String goodsMaterial;

    private String goodsBrand;

    private String goodsPicture;

    private Date goodsCreateTime;

    private Date goodsUpdateTime;

    private Byte goodsState;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsBarcode() {
        return goodsBarcode;
    }

    public void setGoodsBarcode(String goodsBarcode) {
        this.goodsBarcode = goodsBarcode;
    }

    public BigDecimal getGoodsSaleprice() {
        return goodsSaleprice;
    }

    public void setGoodsSaleprice(BigDecimal goodsSaleprice) {
        this.goodsSaleprice = goodsSaleprice;
    }

    public String getGoodsSpecification() {
        return goodsSpecification;
    }

    public void setGoodsSpecification(String goodsSpecification) {
        this.goodsSpecification = goodsSpecification;
    }

    public String getGoodsMetricunit() {
        return goodsMetricunit;
    }

    public void setGoodsMetricunit(String goodsMetricunit) {
        this.goodsMetricunit = goodsMetricunit;
    }

    public BigDecimal getGoodsBuyprice() {
        return goodsBuyprice;
    }

    public void setGoodsBuyprice(BigDecimal goodsBuyprice) {
        this.goodsBuyprice = goodsBuyprice;
    }

    public BigDecimal getGoodsMemprice() {
        return goodsMemprice;
    }

    public void setGoodsMemprice(BigDecimal goodsMemprice) {
        this.goodsMemprice = goodsMemprice;
    }

    public String getGoodsDestination() {
        return goodsDestination;
    }

    public void setGoodsDestination(String goodsDestination) {
        this.goodsDestination = goodsDestination;
    }

    public String getGoodsProduceplace() {
        return goodsProduceplace;
    }

    public void setGoodsProduceplace(String goodsProduceplace) {
        this.goodsProduceplace = goodsProduceplace;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsSupplier() {
        return goodsSupplier;
    }

    public void setGoodsSupplier(String goodsSupplier) {
        this.goodsSupplier = goodsSupplier;
    }

    public String getGoodsMaterial() {
        return goodsMaterial;
    }

    public void setGoodsMaterial(String goodsMaterial) {
        this.goodsMaterial = goodsMaterial;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public Date getGoodsUpdateTime() {
        return goodsUpdateTime;
    }

    public void setGoodsUpdateTime(Date goodsUpdateTime) {
        this.goodsUpdateTime = goodsUpdateTime;
    }

    public Byte getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Byte goodsState) {
        this.goodsState = goodsState;
    }
}