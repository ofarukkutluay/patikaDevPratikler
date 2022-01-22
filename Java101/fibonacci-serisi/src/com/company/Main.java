package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Eleman sayısını giriniz : ");
        int n = in.nextInt();


        int x =0;
        int y= 1;
        while(n>=0){
            y = x+y;
            System.out.println(x);
            x = y-x;
            n--;
        }



    }
}
