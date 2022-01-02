package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Sayıyı giriniz : ");
        n = in.nextInt();

        int result = 0;
        for (int i = 1; i < n; i++) {
            if (n%i==0){
                result = result + i;
            }
        }
        if(result == n){
            System.out.println(n + " mükemmel sayıdır.");
        }else{
            System.out.println(n+" mükemmel sayı değildir.");
        }

    }
}
