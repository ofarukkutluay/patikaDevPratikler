package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int mat, fizik, kimya, turkce, tarih, muzik, toplam;

        Scanner input = new Scanner(System.in);

        System.out.print("Matematik ders notunuzu giriniz : ");
        mat = input.nextInt();
        System.out.print("Fizik ders notunuzu giriniz : ");
        fizik = input.nextInt();
        System.out.print("Kimya ders notunuzu giriniz : ");
        kimya = input.nextInt();
        System.out.print("Türkçe ders notunuzu giriniz : ");
        turkce = input.nextInt();
        System.out.print("Tarih ders notunuzu giriniz : ");
        tarih = input.nextInt();
        System.out.print("Müzik ders notunuzu giriniz : ");
        muzik = input.nextInt();

        toplam = mat+kimya+fizik+turkce+tarih+muzik;
        double sonuc = toplam / 6;
        System.out.println("Not ortalamanız : " + sonuc);
        System.out.println("Gçeme durumunuz : " + (sonuc>60?"Sınıfı Geçti":"Sınıfta Kaldı"));

    }
}
