package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,r;
        Scanner in = new Scanner(System.in);
        System.out.print("Kümenin eleman sayısı : ");
        n = in.nextInt();
        System.out.print("Oluşturulacak grup sayısı : ");
        r = in.nextInt();
        int nF = n,rF = r,nrF = (n-r);
        for (int i=n-1;i>0;i--){
            nF= nF*i;
        }
        for (int i=r-1;i>0;i--){
            rF= rF*i;
        }
        for (int i=n-r-1;i>0;i--){
            nrF= nrF*i;
        }

        double sonuc = nF /(rF*nrF);
        System.out.println("Sonuc : "+sonuc);
    }
}
