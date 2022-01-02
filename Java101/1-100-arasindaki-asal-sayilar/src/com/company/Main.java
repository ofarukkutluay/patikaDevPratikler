package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <=100 ; i++) {
            int x = 0;
            for (int j = 2; j <= i ; j++) {
                if(i%j==0)
                    x++;
            }
            if (x==1)
                System.out.print(i + " ");
        }
    }
}
