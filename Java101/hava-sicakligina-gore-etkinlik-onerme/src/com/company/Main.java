package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int c;
        Scanner in = new Scanner(System.in);
        System.out.print("Sıcaklık giriniz : ");
        c = in.nextInt();

        switch (c) {
            case 0,1,2,3,4, 5 -> System.out.println("Kayak yapabilirsiniz.");
            case 6,7,8,9,10,11,12,13 ,14,15 -> System.out.println("Sinemeya gidebilirsiniz");
            case 16,17,18,19,20,21,22,23,24,25 -> System.out.println("Piknik yapabilirsiniz");
            default -> System.out.println("Yüzmeye gidebilirsiniz");
        }
    }
}
