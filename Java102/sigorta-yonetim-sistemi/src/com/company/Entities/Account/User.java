package com.company.Entities.Account;

import com.company.Entities.Account.Adress.Address;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> addresses = new ArrayList<>();
    private Date lastLoginDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAdresses() {
        return addresses;
    }

    public void setAdresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
