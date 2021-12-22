package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int km;

        Scanner input = new Scanner(System.in);
        System.out.print("Km giriniz : ");
        km = input.nextInt();

        double hesap = 10 + (km*2.2);

        double sonuc = hesap<20 ? 20 : hesap;

        System.out.println("Taksimetre tutarı : " + sonuc);
    }
}
