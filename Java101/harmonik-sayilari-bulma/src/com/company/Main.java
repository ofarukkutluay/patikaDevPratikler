package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("N sayısını giriniz : ");
        n = in.nextInt();

        double result = 0;

        for (int i = 1; i <= n; i++) {
            result += (1/i);
        }

        System.out.println(result);
    }
}
