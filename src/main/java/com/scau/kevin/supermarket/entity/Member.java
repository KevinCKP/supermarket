package com.scau.kevin.supermarket.entity;

public class Member {
    private Long memberId;

    private Long memberAccount;

    private String memberName;

    private Long memberPhone;

    private Byte memberSex;

    private String memberDescription;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(Long memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(Long memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Byte getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(Byte memberSex) {
        this.memberSex = memberSex;
    }

    public String getMemberDescription() {
        return memberDescription;
    }

    public void setMemberDescription(String memberDescription) {
        this.memberDescription = memberDescription;
    }
}