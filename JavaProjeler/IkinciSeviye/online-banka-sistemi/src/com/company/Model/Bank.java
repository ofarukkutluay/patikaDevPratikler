package com.company.Model;

public class Bank {
    private long userId;
    private double creditCard;
    private double credit;
    private double safe;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(double creditCard) {
        this.creditCard = creditCard;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getSafe() {
        return safe;
    }

    public void setSafe(double safe) {
        this.safe = safe;
    }
}
