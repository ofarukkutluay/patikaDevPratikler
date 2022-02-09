package com.company;

import com.company.Entities.Account.Account;
import com.company.Entities.Account.Enterprise;
import com.company.Entities.Account.Individual;
import com.company.Entities.Account.User;
import com.company.Handles.CustomException.InvalidAuthenticationException;
import com.company.Services.AccountManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidAuthenticationException {
        AccountManager accountManager = new AccountManager();
        User user1 = new User();
        user1.setEmail("user1@test.com");
        user1.setPassword("12345");
        Enterprise enterprise1 = new Enterprise();
        enterprise1.setUser(user1);
        accountManager.addEnterprise(enterprise1);

        User user2 = new User();
        user2.setEmail("user2@test.com");
        user2.setPassword("54321");
        Individual individual1 = new Individual();
        individual1.setUser(user2);
        accountManager.addIndividual(individual1);

        User user3 = new User();
        user1.setEmail("user3@test.com");
        user1.setPassword("123");
        Enterprise enterprise2 = new Enterprise();
        enterprise1.setUser(user3);
        accountManager.addEnterprise(enterprise2);

        for (Account a:accountManager.getAll()) {
            a.showUserInfo();
        }

        System.out.println("Login Page");
        Scanner in = new Scanner(System.in);
        System.out.print("Email : ");
        String email = in.next();
        System.out.print("Password : ");
        String pass = in.next();

        accountManager.login(email,pass);
    }
}
