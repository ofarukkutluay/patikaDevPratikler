package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Basamak sayısını giriniz : ");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-(n-i)); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <(2*(n-i)); j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
