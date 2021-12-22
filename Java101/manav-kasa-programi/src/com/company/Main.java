package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int armut,elma,domates,muz,patlican;
        Scanner in = new Scanner(System.in);
        System.out.print("Armut kilosu ? : ");
        armut = in.nextInt();
        System.out.print("Elma kilosu ? : ");
        elma = in.nextInt();
        System.out.print("Domates kilosu ? : ");
        domates = in.nextInt();
        System.out.print("Muz kilosu ? : ");
        muz = in.nextInt();
        System.out.print("Patlıcan kilosu ? : ");
        patlican = in.nextInt();

        double toplam = (armut*2.14)+(elma*3.67)+(domates*1.11)+(muz*0.95)+(patlican*5);
        System.out.print("Toplam tutar : "+ toplam);
    }
}
