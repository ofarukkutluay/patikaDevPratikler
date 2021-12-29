package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int x,n;
        Scanner in = new Scanner(System.in);
        System.out.print("Sayıyı giriniz : ");
        x = in.nextInt();
        System.out.print("Üs giriniz : ");
        n= in.nextInt();
        int xn=1;

        for (int i=0;i<n;i++){
            xn=xn*x;
        }

        System.out.println(xn);
    }
}
