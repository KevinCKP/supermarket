package com.scau.kevin.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Supplier {
    private Long supplierId;

    private String supplierName;

    private String supplierLinkman;

    private Long supplierPhone;

    private String supplierAddress;

    private String supplierBank;

    private Long supplierAccount;

    private String supplierNote;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date supplierCreateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date supplierUpdateTime;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierLinkman() {
        return supplierLinkman;
    }

    public void setSupplierLinkman(String supplierLinkman) {
        this.supplierLinkman = supplierLinkman;
    }

    public Long getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(Long supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierBank() {
        return supplierBank;
    }

    public void setSupplierBank(String supplierBank) {
        this.supplierBank = supplierBank;
    }

    public Long getSupplierAccount() {
        return supplierAccount;
    }

    public void setSupplierAccount(Long supplierAccount) {
        this.supplierAccount = supplierAccount;
    }

    public String getSupplierNote() {
        return supplierNote;
    }

    public void setSupplierNote(String supplierNote) {
        this.supplierNote = supplierNote;
    }

    public Date getSupplierCreateTime() {
        return supplierCreateTime;
    }

    public void setSupplierCreateTime(Date supplierCreateTime) {
        this.supplierCreateTime = supplierCreateTime;
    }

    public Date getSupplierUpdateTime() {
        return supplierUpdateTime;
    }

    public void setSupplierUpdateTime(Date supplierUpdateTime) {
        this.supplierUpdateTime = supplierUpdateTime;
    }
}