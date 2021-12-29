package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Sayı giriniz : ");
        n = in.nextInt();

        for (int i=0; i<=n;i++){
            int number = 1;
            for (int j = 1; j <= i; j++) {
                number = number * 4;
            }
            System.out.println(number);
        }

        for (int i=0; i<=n;i++){
            int number = 1;
            for (int j = 1; j <= i; j++) {
                number = number * 5;
            }
            System.out.println(number);
        }
    }
}
