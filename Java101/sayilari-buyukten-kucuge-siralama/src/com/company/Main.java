package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a, b, c;
        Scanner in = new Scanner(System.in);

        System.out.print("İlk sayıyı giriniz : ");
        a = in.nextInt();
        System.out.print("İkinci sayıyı giriniz : ");
        b = in.nextInt();
        System.out.print("Üçüncü sayıyı giriniz : ");
        c = in.nextInt();

        if (a <= b && a <= c) {
            if (b <= c)
                System.out.println("Küçükten büyüğe :" + a + "," + b + "," + c);
            else
                System.out.println("Küçükten büyüğe :" + a + "," + c + "," + b);
        } else if (a >= b && a >= c) {
            if (b >= c)
                System.out.println("Küçükten büyüğe :" + c + "," + b + "," + a);
            else
                System.out.println("Küçükten büyüğe :" + b + "," + c + "," + a);
        } else if (b >= a && b >= c) {
            if (a >= c)
                System.out.println("Küçükten büyüğe :" + c + "," + a + "," + b);
            else
                System.out.println("Küçükten büyüğe :" + a + "," + c + "," + b);
        } else if (b <= a && b <= c) {
            if (a >= c)
                System.out.println("Küçükten büyüğe :" + b + "," + c + "," + a);
            else
                System.out.println("Küçükten büyüğe :" + b + "," + a + "," + c);
        } else if (c >= a && c >= b) {
            if (a >= b)
                System.out.println("Küçükten büyüğe :" + b + "," + a + "," + c);
            else
                System.out.println("Küçükten büyüğe :" + a + "," + b + "," + c);
        } else if (c <= a && c <= b) {
            if (b >= a)
                System.out.println("Küçükten büyüğe :" + c + "," + a + "," + b);
            else
                System.out.println("Küçükten büyüğe :" + c + "," + b + "," + a);
        }
    }
}
