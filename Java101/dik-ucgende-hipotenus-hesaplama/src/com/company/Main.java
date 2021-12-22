package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a,b,c;
        Scanner input = new Scanner(System.in);

        System.out.println("Dik üçgenin dik kenar uzunluklarını giriniz...");
        System.out.print("1. kenar : ");
        a = input.nextDouble();
        System.out.print("2. kenar : ");
        b = input.nextDouble();

        c = Math.sqrt((a*a)+(b*b));
        System.out.println("Hipotenus : "+ c);



    }
}
