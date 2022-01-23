package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{5,6,7}};
        int[][] transpoz = new int[array[0].length][array.length];

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                transpoz[i][j] = array[j][i];
            }
        }

        System.out.println("Transpozu : ");
        for (int i = 0; i < transpoz.length; i++) {
            for (int j = 0; j < transpoz[0].length; j++) {
                System.out.print(transpoz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
