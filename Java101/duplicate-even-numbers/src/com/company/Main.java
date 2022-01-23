package com.company;

import java.util.Arrays;

public class Main {

    static boolean varMi(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return false;
            }

        }return true;
    }

    public static void main(String[] args) {
        int[] dizi = {1, 2, 3, 4, 4, 5, 6, 7, 8, 6, 9, 8, 1, 8};
        int[] tekrar =new int[dizi.length];
        int indeks=0;
        for (int i = 0; i < dizi.length; i++) {
            for(int j=0;j< dizi.length;j++){
                if((i!=j) && dizi[i]==dizi[j] && dizi[i]%2==0){
                    if (varMi(tekrar,dizi[i])){
                        tekrar[indeks]= dizi[i];
                        indeks++;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(tekrar));
    }
}