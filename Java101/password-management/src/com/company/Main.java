package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userName,password;

        Scanner in = new Scanner(System.in);
        System.out.print("Kullanıcı adını giriniz : ");
        userName = in.nextLine();
        System.out.print("Şifre giriniz : ");
        password = in.nextLine();

        String INITIAL_USERNAME = "kullanici";
        String INITIAL_PASSWORD = "java123";

        if (userName.equals(INITIAL_USERNAME) && password.equals(INITIAL_PASSWORD)){
            System.out.println("Başarılı şekildegiriş yappıldı");
        }else if(!password.equals(INITIAL_PASSWORD)){
            System.out.print("Şifre hatalı yeni şifre oluşturmak ister misiniz? (y/n) : ");
            String yn = in.nextLine();
            if (yn.equals("y")){
                System.out.print("Yeni şifreyi giriniz : ");
                String newPass = in.nextLine();
                if (newPass.equals( INITIAL_PASSWORD)){
                    System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                }else{
                    INITIAL_PASSWORD = newPass;
                    System.out.println("Şifre Oluşturuldu.");
                }

            }
        }

    }
}
