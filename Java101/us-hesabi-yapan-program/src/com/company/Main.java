package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Taban değeri giriniz : ");
        int taban = in.nextInt();
        System.out.print("Us değeri giriniz : ");
        int us = in.nextInt();

        System.out.println(usAlma(taban,us));
    }

    public static int usAlma(int taban,int us){
        us-=1;
        if (us==0)
            return taban;
        return taban*usAlma(taban,us);
    }
}
