package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int sy1,sy2,select;

        Scanner in = new Scanner(System.in);
        System.out.println("1-Toplama \n2-Çıkarma\n3-Çarpma\n4-Bölme");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        select = in.nextInt();
        System.out.print("Birinci sayıyı giriniz :");
        sy1 = in.nextInt();
        System.out.print("İkinci sayıyı giriniz :");
        sy2 = in.nextInt();

        switch (select){
            case 1:
                System.out.println("Toplama sonucu : "+(sy1+sy2));
                break;
            case 2:
                System.out.println("Çıkarma sonucu : "+(sy1-sy2) );
                break;
            case 3:
                System.out.println("Çarpma sonucu : "+(sy1*sy2) );
                break;
            case 4:
                System.out.println("Bölme sonucu : "+(sy1/sy2) );
                break;
            default:
                System.out.println("Yanlış seçim yaptınız!");
        }

    }
}
