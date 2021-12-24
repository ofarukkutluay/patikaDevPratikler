package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int yil;
        Scanner in = new Scanner(System.in);
        System.out.print("Doğum yılınızı giriniz : ");
        yil = in.nextInt();

        int kalan = yil%12;
        String burc = "";

        switch (kalan){
            case 0:
                burc = "Maymun";
                break;
            case 1:
                burc = "Horoz";
                break;
            case 2:
                burc = "Köpek";
                break;
            case 3:
                burc = "Domuz";
                break;
            case 4:
                burc = "Fare";
                break;
            case 5:
                burc = "Öküz";
                break;
            case 6:
                burc = "Kaplan";
                break;
            case 7:
                burc = "Tavşan";
                break;
            case 8:
                burc = "Ejderya";
                break;
            case 9:
                burc = "Yılan";
                break;
            case 10:
                burc = "At";
                break;
            case 11:
                burc = "Koyun";
                break;
            default:
                burc = "";
                break;
        }

        System.out.println("Çin zodyağı burcunuz : " + burc);
    }
}
