package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    double kg,boy,index;

        Scanner in = new Scanner(System.in);
        System.out.print("Lütfen boyunuzu metre cinsinde giriniz : ");
        boy = in.nextDouble();
        System.out.print("Lütfen kilonuzu kilogram cinsinde giriniz : ");
        kg = in.nextDouble();

        index = kg/ (boy*boy);

        System.out.println("Vücut kitle endeksiniz : "+ index);


    }
}
