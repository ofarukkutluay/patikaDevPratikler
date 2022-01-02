package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,min=0,max=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Kaç sayı gireceksiniz : ");
        n = in.nextInt();

        if (n<2)
            System.out.println("İkiden az sayı giremezsiniz!");
        else{
            for (int i = 1; i <= n; i++) {
                System.out.print(i+ ". sayıyı giriniz : ");
                int first = in.nextInt();
                if(min>=first){
                    min = first;
                }else if(max<=first){
                    max = first;
                }else if(min>=first && first == 0){
                    min = first;
                }else if(min == 0){
                    min = first;
                }else if(max == 0){
                    max = first;
                }

            }
            System.out.println("Girilen en büyük sayı = "+ max);
            System.out.println("Girilen en küçük sayı = "+ min);
        }


    }
}
