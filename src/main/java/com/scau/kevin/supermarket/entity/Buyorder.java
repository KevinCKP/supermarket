package com.scau.kevin.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Buyorder {
    private Long boId;

    private Long boAssessor;

    private Long boBuyer;

    private String boBuyername;

    private String boAssessorname;

    private BigDecimal boTotal;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date boDate;

    private String boNote;

    private Byte boState;

    private Boolean boIsfinished;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private List<Buydetail> buydetails;

    public Long getBoId() {
        return boId;
    }

    public void setBoId(Long boId) {
        this.boId = boId;
    }

    public Long getBoAssessor() {
        return boAssessor;
    }

    public void setBoAssessor(Long boAssessor) {
        this.boAssessor = boAssessor;
    }

    public Long getBoBuyer() {
        return boBuyer;
    }

    public void setBoBuyer(Long boBuyer) {
        this.boBuyer = boBuyer;
    }

    public String getBoBuyername() {
        return boBuyername;
    }

    public void setBoBuyername(String boBuyername) {
        this.boBuyername = boBuyername;
    }

    public String getBoAssessorname() {
        return boAssessorname;
    }

    public void setBoAssessorname(String boAssessorname) {
        this.boAssessorname = boAssessorname;
    }

    public BigDecimal getBoTotal() {
        return boTotal;
    }

    public void setBoTotal(BigDecimal boTotal) {
        this.boTotal = boTotal;
    }

    public Date getBoDate() {
        return boDate;
    }

    public void setBoDate(Date boDate) {
        this.boDate = boDate;
    }

    public String getBoNote() {
        return boNote;
    }

    public void setBoNote(String boNote) {
        this.boNote = boNote;
    }

    public Byte getBoState() {
        return boState;
    }

    public void setBoState(Byte boState) {
        this.boState = boState;
    }

    public Boolean getBoIsfinished() {
        return boIsfinished;
    }

    public void setBoIsfinished(Boolean boIsfinished) {
        this.boIsfinished = boIsfinished;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Buydetail> getBuydetails() {
        return buydetails;
    }

    public void setBuydetails(List<Buydetail> buydetails) {
        this.buydetails = buydetails;
    }
}