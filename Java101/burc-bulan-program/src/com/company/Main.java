package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int ay,gun ;
        Scanner in = new Scanner(System.in);
        System.out.print("Doğduğunuz ay : ");
        ay = in.nextInt();
        System.out.print("Doğduğunuz gün : ");
        gun = in.nextInt();

        if (ay==3){
            if(gun>=21)
                System.out.println("Koç burcu");
            else
                System.out.println("Balık burcu");
        }else if(ay==4){
            if(gun<=20)
                System.out.println("Koç burcu");
            else
                System.out.println("Boğa burcu");
        }else if(ay==5){
            if(gun<=21)
                System.out.println("Boğa burcu");
            else
                System.out.println("İkizler burcu");
        }else if(ay==6){
            if(gun<=22)
                System.out.println("İkizler burcu");
            else
                System.out.println("Yengeç burcu");
        }else if(ay==7){
            if(gun<=22)
                System.out.println("Yengeç burcu");
            else
                System.out.println("Aslan burcu");
        }else if(ay==8){
            if(gun<=22)
                System.out.println("Aslan burcu");
            else
                System.out.println("Başak burcu");
        }else if(ay==9){
            if(gun<=22)
                System.out.println("Başak burcu");
            else
                System.out.println("Terazi burcu");
        }else if(ay==10){
            if(gun<=22)
                System.out.println("Terazi burcu");
            else
                System.out.println("Akrep burcu");
        }else if(ay==11){
            if(gun<=21)
                System.out.println("Akrep burcu");
            else
                System.out.println("Yay burcu");
        }else if(ay==12){
            if(gun<=21)
                System.out.println("Yay burcu");
            else
                System.out.println("Oğlak burcu");
        }else if(ay==1){
            if(gun<=21)
                System.out.println("Oğlak burcu");
            else
                System.out.println("Kova burcu");
        }else if(ay==2){
            if(gun<=19)
                System.out.println("Kova burcu");
            else
                System.out.println("Balık burcu");
        }
    }
}
