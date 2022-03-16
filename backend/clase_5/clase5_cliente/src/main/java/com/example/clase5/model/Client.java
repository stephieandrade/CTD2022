package com.example.clase5.model;

public class Client {
    private Long id;
    private String fullname;
    private Boolean creditAvaiable;
    private Integer income;

    public Client() {
    }

    public Client(Long id, String fullname, Boolean creditAvaiable, Integer income) {
        this.id = id;
        this.fullname = fullname;
        this.creditAvaiable = creditAvaiable;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getCreditAvaiable() {
        return creditAvaiable;
    }

    public void setCreditAvaiable(Boolean creditAvaiable) {
        this.creditAvaiable = creditAvaiable;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }
}
