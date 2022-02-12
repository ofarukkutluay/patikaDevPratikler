package com.company;

import java.util.ArrayList;

public class EvenNumbers extends Thread {

    public ArrayList<Integer> tempList;

    ArrayList<Integer> evenList = new ArrayList<>();

    public EvenNumbers(ArrayList<Integer> tempList) {
        this.tempList = tempList;
    }

    @Override
    public void run() {
        synchronized (new Object()){
            for (int i = 0; i < tempList.size() ; i++) {
                if(tempList.get(i) % 2 == 0) {
                    evenList.add(tempList.get(i));
                }
            }
        }

        //print();
    }

    public void print(){
        System.out.println(evenList.toString());
    }
}
