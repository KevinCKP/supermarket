package com.scau.kevin.supermarket.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Salerecord {
    private Long srId;

    private Long staffId;

    private Long memberId;

    private BigDecimal srTotal;

    private BigDecimal srActualcharge;

    private BigDecimal srChange;

    private Date srDate;

    private String staffNote;

    private BigDecimal srProfit;

    private String srSalesman;

    private Integer srNumber;

    private List<Saledetail> saledetails;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getSrTotal() {
        return srTotal;
    }

    public void setSrTotal(BigDecimal srTotal) {
        this.srTotal = srTotal;
    }

    public BigDecimal getSrActualcharge() {
        return srActualcharge;
    }

    public void setSrActualcharge(BigDecimal srActualcharge) {
        this.srActualcharge = srActualcharge;
    }

    public BigDecimal getSrChange() {
        return srChange;
    }

    public void setSrChange(BigDecimal srChange) {
        this.srChange = srChange;
    }

    public Date getSrDate() {
        return srDate;
    }

    public void setSrDate(Date srDate) {
        this.srDate = srDate;
    }

    public String getStaffNote() {
        return staffNote;
    }

    public void setStaffNote(String staffNote) {
        this.staffNote = staffNote;
    }

    public BigDecimal getSrProfit() {
        return srProfit;
    }

    public void setSrProfit(BigDecimal srProfit) {
        this.srProfit = srProfit;
    }

    public String getSrSalesman() {
        return srSalesman;
    }

    public void setSrSalesman(String srSalesman) {
        this.srSalesman = srSalesman;
    }

    public Integer getSrNumber() {
        return srNumber;
    }

    public void setSrNumber(Integer srNumber) {
        this.srNumber = srNumber;
    }

    public List<Saledetail> getSaledetails() {
        return saledetails;
    }

    public void setSaledetails(List<Saledetail> saledetails) {
        this.saledetails = saledetails;
    }
}