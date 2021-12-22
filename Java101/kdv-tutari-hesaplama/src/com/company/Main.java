package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double netFiyat;

        Scanner input = new Scanner(System.in);
        System.out.print("Kdv hesaplanacak net fiyatı giriniz : ");
        netFiyat = input.nextDouble();

        double kdvliSonuc = netFiyat<1000 && netFiyat>0 ? netFiyat*1.18 : netFiyat*1.08;

        System.out.println("KDV'li Fiyat : " +kdvliSonuc);
        System.out.println("KDV tutarı : " + (kdvliSonuc-netFiyat));

    }
}
