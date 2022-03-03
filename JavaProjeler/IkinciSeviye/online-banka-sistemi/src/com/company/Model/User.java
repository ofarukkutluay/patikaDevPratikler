package com.company.Model;

import java.time.LocalDate;

public class User {
    private long id;
    private String tc_number;
    private String name;
    private String birth_date;
    private String pass;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTc_number() {
        return tc_number;
    }

    public void setTc_number(String tc_number) {
        this.tc_number = tc_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
