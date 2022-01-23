package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {10,20,10,10,20,5,20,14,34,23,23,14,75};
        Arrays.sort(array);
        int sayi = -1;
        int tekrar = 1;
        for (int i = 0; i < array.length; i++) {
            if(sayi == array[i])
                tekrar +=1;
            if(sayi!=array[i]){
                if(sayi!=-1)
                    System.out.println(sayi + " sayısı "+ tekrar + " tekrar etmiştir.");
                sayi = array[i];
                tekrar = 1;
            }
        }
        System.out.println(sayi + " sayısı "+ tekrar + " tekrar etmiştir.");
    }
}
