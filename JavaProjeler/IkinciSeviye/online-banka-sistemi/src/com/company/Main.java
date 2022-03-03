package com.company;


import com.company.Controller.AuthController;
import com.company.Controller.BankController;
import com.company.Model.Bank;
import com.company.Model.User;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        User user= new User();
        user.setId(3);
        user.setName("Ahmet");
        user.setTc_number("12345678912");
        user.setPass("1990-02-05");
        user.setBirth_date(LocalDate.of(1990,2,5).toString());

        Bank bank = new Bank();
        bank.setUserId(2);
        bank.setCredit(1000);
        bank.setCreditCard(1250);
        bank.setSafe(50000);

        //AuthController auth = new AuthController();
        //auth.register(user.getId(),user.getName(), user.getTc_number(), user.getBirth_date(), user.getPass());

        BankController bankController = new BankController();
        //bankController.addBank(bank.getUserId(),bank.getCreditCard(),bank.getCredit(),bank.getSafe());
        //bankController.payCredit(3,250);
        bankController.sendAmountUser(2,3,1550);
    }
}
