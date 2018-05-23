package com.bysj.pss.model.pojo;

public class Enterprise {
    private Integer id;

    private String name;

    private String legalPerson;

    private String contactName;

    private Long contactMobile;

    private String email;

    private String address;

    private String socialCreditCode;

    private Byte type;

    private Byte bank;

    private String bankCount;

    private String taxNumber;

    private String drugBusiness;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public Long getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(Long contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode == null ? null : socialCreditCode.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getBank() {
        return bank;
    }

    public void setBank(Byte bank) {
        this.bank = bank;
    }

    public String getBankCount() {
        return bankCount;
    }

    public void setBankCount(String bankCount) {
        this.bankCount = bankCount == null ? null : bankCount.trim();
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber == null ? null : taxNumber.trim();
    }

    public String getDrugBusiness() {
        return drugBusiness;
    }

    public void setDrugBusiness(String drugBusiness) {
        this.drugBusiness = drugBusiness == null ? null : drugBusiness.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}