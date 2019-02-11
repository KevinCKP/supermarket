package com.scau.kevin.supermarket.entity;

import java.util.Date;
import java.util.List;

public class Buyreturn {
    private Long brId;

    private Long brOperatorId;

    private Long brSupplierId;

    private Long brTotal;

    private Date brCreateTime;

    private Date brHandleDate;

    private String brPassword;

    private String brNote;

    private Byte brState;

    private String brOperatorName;

    private String brSupplierName;

    List<Buyreturndetail> buyreturndetails;

    public Long getBrId() {
        return brId;
    }

    public void setBrId(Long brId) {
        this.brId = brId;
    }

    public Long getBrOperatorId() {
        return brOperatorId;
    }

    public void setBrOperatorId(Long brOperatorId) {
        this.brOperatorId = brOperatorId;
    }

    public Long getBrSupplierId() {
        return brSupplierId;
    }

    public void setBrSupplierId(Long brSupplierId) {
        this.brSupplierId = brSupplierId;
    }

    public Long getBrTotal() {
        return brTotal;
    }

    public void setBrTotal(Long brTotal) {
        this.brTotal = brTotal;
    }

    public Date getBrCreateTime() {
        return brCreateTime;
    }

    public void setBrCreateTime(Date brCreateTime) {
        this.brCreateTime = brCreateTime;
    }

    public Date getBrHandleDate() {
        return brHandleDate;
    }

    public void setBrHandleDate(Date brHandleDate) {
        this.brHandleDate = brHandleDate;
    }

    public String getBrPassword() {
        return brPassword;
    }

    public void setBrPassword(String brPassword) {
        this.brPassword = brPassword;
    }

    public String getBrNote() {
        return brNote;
    }

    public void setBrNote(String brNote) {
        this.brNote = brNote;
    }

    public Byte getBrState() {
        return brState;
    }

    public void setBrState(Byte brState) {
        this.brState = brState;
    }

    public String getBrOperatorName() {
        return brOperatorName;
    }

    public void setBrOperatorName(String brOperatorName) {
        this.brOperatorName = brOperatorName;
    }

    public String getBrSupplierName() {
        return brSupplierName;
    }

    public void setBrSupplierName(String brSupplierName) {
        this.brSupplierName = brSupplierName;
    }

    public List<Buyreturndetail> getBuyreturndetails() {
        return buyreturndetails;
    }

    public void setBuyreturndetails(List<Buyreturndetail> buyreturndetails) {
        this.buyreturndetails = buyreturndetails;
    }
}