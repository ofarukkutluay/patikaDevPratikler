package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double r;
        Scanner in = new Scanner(System.in);
        System.out.print("Yarı çapı giriniz : ");
        r = in.nextDouble();
        double pi = 3.14;
        double alan = pi*r*r;
        double cevre = 2*pi*r;

        System.out.println("Dairenin alanı : "+ alan);
        System.out.println("Dairenin çevresi : "+ cevre);

    }
}
