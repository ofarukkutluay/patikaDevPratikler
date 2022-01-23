package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Oluşturacağınız dizinin boyutunu giriniz : ");
        int length = in.nextInt();
        int[] array = new int[length];
        for (int i = 0; i <length ; i++) {
            System.out.print((i+1) +" . sayıyı giriniz : ");
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        for (int ar:array) {
            System.out.print(ar + " ");
        }

    }
}
