package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Sayı giriniz : ");
        Scanner in = new Scanner(System.in);
        int sayi = in.nextInt();
        var success = isPalidrom(sayi);
        if(success)
            System.out.println("Sayı polidromdur");
        else
            System.out.println("Sayı polidrom değildir.");
    }

    public static boolean isPalidrom(int number){
        int temp = number , reverseNumber=0, lastNumber;
        while(temp!=0){
            lastNumber = temp%10;
            reverseNumber = (reverseNumber*10)+lastNumber;
            temp/=10;
        }
        if(number==reverseNumber){
            return true;
        }else{
            return false;
        }

    }
}
