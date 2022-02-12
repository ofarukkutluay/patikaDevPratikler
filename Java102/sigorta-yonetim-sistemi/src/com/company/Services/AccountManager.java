package com.company.Services;

import com.company.Entities.Account.Account;
import com.company.Entities.Account.AuthenticationStatus;
import com.company.Entities.Account.Enterprise;
import com.company.Entities.Account.Individual;
import com.company.Handles.CustomException.InvalidAuthenticationException;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts = new TreeSet<>();
    public void addEnterprise(Enterprise enterprise){
        accounts.add(enterprise);
    }
    public void addIndividual(Individual individual){
        accounts.add(individual);
    }
    public TreeSet<Account> getAll(){
        return accounts;
    }
    public Account login(String email,String password) {
        for (Account account:accounts) {
            if (account.getUser().getEmail().equals(email)){
                try{
                    account.loginUser(email,password);
                    return account;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            if (account.getAuthenticationStatus() == AuthenticationStatus.FAIL) {
                System.out.println("Giriş Başarısız!");
            }
        }
        return null;
    }
}
