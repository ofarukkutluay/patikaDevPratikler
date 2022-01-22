package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] list = {56, 34, 1, 8, 101, -2, -33};

        int min = list[0];
        int max = list[0];

        for (int i : list) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        System.out.println("Minimum Değer " + min);
        System.out.println("Maximum Değer " + max);

        Scanner in = new Scanner(System.in);
        System.out.print("Sayı giriniz : ");
        int x = in.nextInt();
        int yakinK = list[0];
        int yakinB = list[0];

        for(int i : list){
            int fark = x-i;
            if(fark <= 0)
                yakinK = i;
            if(fark>=0){
                yakinB = i;
            }
        }

        System.out.println("Küçük yakın " + min);
        System.out.println("Büyük yakın " + max);

    }
}
