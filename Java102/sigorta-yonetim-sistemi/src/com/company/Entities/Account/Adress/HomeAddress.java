package com.company.Entities.Account.Adress;

public class HomeAddress implements Address{
    private String address;
    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}
