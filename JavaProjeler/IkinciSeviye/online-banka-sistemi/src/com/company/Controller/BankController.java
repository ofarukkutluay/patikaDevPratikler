package com.company.Controller;

import com.company.Database.BankDb;
import com.company.Database.UserDb;
import com.company.Model.Bank;

public class BankController {
    BankDb bankdb;
    UserDb userDb;
    public BankController (){
        this.bankdb = new BankDb();
        this.userDb = new UserDb();
    }

    public boolean addBank(long userId,double creditCard,double credit,double safe){
        Bank bank = new Bank();
        bank.setUserId(userId);
        bank.setCreditCard(creditCard);
        bank.setCredit(credit);
        bank.setSafe(safe);
        this.bankdb.add(bank);
        System.out.println("Banka kaydı girildi!");
        return true;
    }

    public boolean payCredit(long userId ,double amount){
        Bank bank = this.bankdb.getByUserId(userId);
        if(bank==null){
            System.out.println("Kullanıcı bulunamadı!");
        }
        double credit =  bank.getCredit();
        double safe = bank.getSafe();
        bank.setCredit(credit-amount);
        bank.setSafe(safe-amount);
        if(this.bankdb.update(userId,bank)){
            System.out.println("Kredi ödemesi alındı!");
            return true;
        }else{
            System.out.println("Kredi ödemesi alınamadı!");
            return false;
        }

    }
    public boolean payCreditCard(long userId ,double amount){
        Bank bank = this.bankdb.getByUserId(userId);
        if(bank==null){
            System.out.println("Kullanıcı bulunamadı!");
        }
        double creditCard =  bank.getCreditCard();
        double safe = bank.getSafe();
        bank.setCreditCard(creditCard-amount);
        bank.setSafe(safe-amount);
        if(this.bankdb.update(userId,bank)){
            System.out.println("Kredi kartı ödemesi alındı!");
            return true;
        }else{
            System.out.println("Kredi kartı ödemesi alınamadı!");
            return false;
        }
    }

    public boolean sendAmountUser(long exportUserId,long importUserId,double amount){
        Bank exportBank = this.bankdb.getByUserId(exportUserId);
        Bank importBank = this.bankdb.getByUserId(importUserId);
        double exportSafe = exportBank.getSafe();
        double importSafe = importBank.getSafe();

        exportBank.setSafe(exportSafe-amount);
        importBank.setSafe(importSafe-amount);

        if(this.bankdb.update(exportUserId,exportBank) && this.bankdb.update(importUserId,importBank)){
            System.out.println("Para transferi gerçekleşti");
            return true;
        }else{
            System.out.println("Para trasferi gerçekleştirilemedi");
            return false;
        }
    }
}
