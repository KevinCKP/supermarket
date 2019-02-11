package com.scau.kevin.supermarket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Staff {
    private Long staffId;

    private String staffName;

    private Byte staffSex;

    private String staffPlace;

    private Integer staffSalary;

    private Long staffPhone;

    private String staffAddress;

    private String staffIdcard;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date staffEmploydate;

    private String staffPicture;

    private String staffNote;

    private String staffType;

    private Date staffCreateTime;

    private Date staffUpdateTime;

    private String staffPassword;

    private Byte staffRole;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Byte getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(Byte staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffPlace() {
        return staffPlace;
    }

    public void setStaffPlace(String staffPlace) {
        this.staffPlace = staffPlace;
    }

    public Integer getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(Integer staffSalary) {
        this.staffSalary = staffSalary;
    }

    public Long getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(Long staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffIdcard() {
        return staffIdcard;
    }

    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard;
    }

    public Date getStaffEmploydate() {
        return staffEmploydate;
    }

    public void setStaffEmploydate(Date staffEmploydate) {
        this.staffEmploydate = staffEmploydate;
    }

    public String getStaffPicture() {
        return staffPicture;
    }

    public void setStaffPicture(String staffPicture) {
        this.staffPicture = staffPicture;
    }

    public String getStaffNote() {
        return staffNote;
    }

    public void setStaffNote(String staffNote) {
        this.staffNote = staffNote;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public Date getStaffCreateTime() {
        return staffCreateTime;
    }

    public void setStaffCreateTime(Date staffCreateTime) {
        this.staffCreateTime = staffCreateTime;
    }

    public Date getStaffUpdateTime() {
        return staffUpdateTime;
    }

    public void setStaffUpdateTime(Date staffUpdateTime) {
        this.staffUpdateTime = staffUpdateTime;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public Byte getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(Byte staffRole) {
        this.staffRole = staffRole;
    }
}