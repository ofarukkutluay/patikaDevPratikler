package com.company;

import java.util.Scanner;

public class Main {

    static int eksi(int n,int temp) {
        System.out.print(n + " ");
        if (n <= 0) {
            return arti(n+5, temp);
        } else {
            return eksi(n - 5, temp);
        }
    }

    static int arti(int n,int temp){
        System.out.print(n + " ");
        if(n==temp){
            return 0;
        }
        else {
            return arti(n+5,temp);
        }
    }
    public static void main(String[] args){

        int n,temp;
        Scanner inp = new Scanner(System.in);

        System.out.print("Bir Sayı giriniz: ");
        n= inp.nextInt();
        temp=n;
        eksi(n,temp);
    }
}
