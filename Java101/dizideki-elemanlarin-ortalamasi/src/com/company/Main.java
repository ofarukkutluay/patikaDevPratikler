package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {6,1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        Arrays.sort(numbers);
        for (int i:numbers) {
            System.out.println(i);
        }

        System.out.println(sum / numbers.length);
    }
}

