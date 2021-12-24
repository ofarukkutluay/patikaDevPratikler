package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int km,tip,yas;

        Scanner in = new Scanner(System.in);
        System.out.print("Mesafeyi km türünden giriniz : ");
        km = in.nextInt();
        System.out.print("Yaşınızı giriniz : ");
        yas = in.nextInt();
        System.out.print("olculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ) : ");
        tip = in.nextInt();

        double priceKm = 0.10;
        double ggDiscount = 0.20;
        double oldDiscount = 0.30;
        double childDiscount = 0.50;
        double youngDiscount = 0.10;
        double result,nPrice;

        if(tip==1){
            nPrice = km*priceKm;
            if(yas<12)
                result = nPrice-(nPrice*childDiscount);
            else if(yas<24)
                result = nPrice-(nPrice*youngDiscount);
            else if(yas>65)
                result = nPrice-(nPrice*oldDiscount);
            else
                result =nPrice;
            System.out.println("Toplam tutar : " + result);
        }else if(tip==2){
            nPrice = km*priceKm*2;
            if(yas<12)
                result = nPrice-((nPrice-(nPrice*childDiscount))*ggDiscount);
            else if(yas<24)
                result = nPrice-((nPrice-(nPrice*youngDiscount))*ggDiscount);
            else if(yas>65)
                result = nPrice-((nPrice-(nPrice*oldDiscount))*ggDiscount);
            else
                result =nPrice;
            System.out.println("Toplam tutar : " + result);

        }else{
            System.out.println("Hatalı Veri Girdiniz !");
        }

    }
}
