package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Sayı Giriniz :");
        int number = input.nextInt();

        int numberCounter = 0;
        int a = number;
        while (a != 0) {
            a /= 10;
            numberCounter++;
        }
        int result = 0;

        for (int i = 0; i < numberCounter; i++) {
            int tenten = 1;
            for (int j=i; j <numberCounter-1; j++) {
                tenten = tenten*10;
            }
            int b = number/tenten;
            int c = b % 10;
            result+=c;
        }

        System.out.println(result);





    }
}
