package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int mat, fizik, turkce, kimya, muzik;

        Scanner in = new Scanner(System.in);
        System.out.print("Matematik notunuzu giriniz : ");
        mat = in.nextInt();
        if (mat>100||mat<0) mat = 0;
        System.out.print("Fizik notunuzu giriniz : ");
        fizik = in.nextInt();
        if (fizik>100||fizik<0) fizik = 0;
        System.out.print("Türkçe notunuzu giriniz : ");
        turkce = in.nextInt();
        if (turkce>100||turkce<0) turkce = 0;
        System.out.print("Kimya notunuzu giriniz : ");
        kimya = in.nextInt();
        if (kimya>100||kimya<0) kimya = 0;
        System.out.print("Müzik notunuzu giriniz : ");
        muzik = in.nextInt();
        if (muzik>100||muzik<0) muzik = 0;

        double average = (mat+fizik+turkce+kimya+muzik)/5;

        if (average <= 55) {
            System.out.println("Sınıfta kaldınız! Ortalama notunuz : "+ average);
        }else{
            System.out.println("Sınıfı geçtiniz! \nOrtalama notunuz : "+average);
        }
    }
}
