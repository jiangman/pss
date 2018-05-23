package com.bysj.pss.model.matadata;

public class EnterpriseDto {
    private Integer id;

    private String name;

    private String legalPerson;

    private String contactName;

    private Long contactMobile;

    private String email;

    private String address;

    private String socialCreditCode;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBank() {
        return bank;
    }

    public void setBank(Integer bank) {
        this.bank = bank;
    }

    private Integer type;

    private Integer bank;

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
        this.name = name;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public String getBankCount() {
        return bankCount;
    }

    public void setBankCount(String bankCount) {
        this.bankCount = bankCount;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getDrugBusiness() {
        return drugBusiness;
    }

    public void setDrugBusiness(String drugBusiness) {
        this.drugBusiness = drugBusiness;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
