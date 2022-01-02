package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Bir Sayı Giriniz : ");
        int n = in.nextInt();

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print("*");
            }

            System.out.println(" ");
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < (n - i); j++) {
                System.out.print("*");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print(" ");
            }
            System.out.println(" ");
        }


    }

}
