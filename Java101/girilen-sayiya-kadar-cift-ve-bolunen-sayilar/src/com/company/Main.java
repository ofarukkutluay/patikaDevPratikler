package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sayi;
        Scanner in = new Scanner(System.in);
        System.out.print("Sayıyı giriniz : ");
        sayi = in.nextInt();

        for (int i=1; i<=sayi ; i++){
            if (i%2==0 && i%3==0 && i%4==0)
                System.out.print(i +",");
        }
    }
}
