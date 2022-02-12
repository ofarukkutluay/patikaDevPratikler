package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> listNumber = new ArrayList<>();

        ArrayList<Integer> listNumber1 = new ArrayList<>(2500);
        ArrayList<Integer> listNumber2 = new ArrayList<>(2500);
        ArrayList<Integer> listNumber3 = new ArrayList<>(2500);
        ArrayList<Integer> listNumber4 = new ArrayList<>(2500);

        ArrayList<Integer> evenNumbers = new ArrayList<>(5000);
        ArrayList<Integer> oddNumbers = new ArrayList<>(5000);

        for(int i=1; i<=10000; i++){
            listNumber.add(i);
        }

        listNumber1.addAll(listNumber.subList(0,2500));
        listNumber2.addAll(listNumber.subList(2500,5000));
        listNumber3.addAll(listNumber.subList(5000,7500));
        listNumber4.addAll(listNumber.subList(7500,10000));

        OddNumbers o1 = new OddNumbers(listNumber1);
        Thread t1 = new Thread(o1);
        t1.start();
        if(!t1.isAlive()){
            oddNumbers.addAll(o1.oddList);
        }

        EvenNumbers e1 = new EvenNumbers(listNumber1);
        Thread t2 = new Thread(e1);
        t2.start();
        if(!t2.isAlive()){
            evenNumbers.addAll(e1.evenList);
        }

        OddNumbers o2 = new OddNumbers(listNumber2);
        Thread t3 = new Thread(o2);
        t3.start();
        if(!t3.isAlive()){
            oddNumbers.addAll(o2.oddList);
        }

        EvenNumbers e2 = new EvenNumbers(listNumber2);
        Thread t4 = new Thread(e2);
        t4.start();
        if(!t4.isAlive()){
            evenNumbers.addAll(e2.evenList);
        }

        OddNumbers o3 = new OddNumbers(listNumber3);
        Thread t5 = new Thread(o3);
        t5.start();
        if(!t5.isAlive()){
            oddNumbers.addAll(o3.oddList);
        }

        EvenNumbers e3 = new EvenNumbers(listNumber3);
        Thread t6 = new Thread(e3);
        t6.start();
        if(!t6.isAlive()){
            evenNumbers.addAll(e3.evenList);
        }

        OddNumbers o4 = new OddNumbers(listNumber4);
        Thread t7 = new Thread(o4);
        t7.start();
        if(!t7.isAlive()){
            oddNumbers.addAll(o4.oddList);
        }

        EvenNumbers e4 = new EvenNumbers(listNumber4);
        Thread t8 = new Thread(e4);
        t8.start();
        if(!t8.isAlive()){
            evenNumbers.addAll(e4.evenList);
        }

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(evenNumbers.toString());
        System.out.println(oddNumbers.toString());
    }
}
