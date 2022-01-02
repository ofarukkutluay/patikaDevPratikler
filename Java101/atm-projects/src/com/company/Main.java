package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userName, password;
        int right = 3;
        int balance = 1500;
        boolean session = true;
        int choice;

        Scanner input = new Scanner(System.in);

        while (right > 0) { //When the user enters incorrectly, users right is reduced

            System.out.print("Enter your name: ");
            userName = input.nextLine();

            System.out.print("Enter your password: ");
            password = input.nextLine();

            if (userName.equals("patikadev") && password.equals("java101")) {
                System.out.println("Hi, Welcome to the Kodluyoruz  Bank!");

                while (session) {

                    System.out.println("1- Withdraw");
                    System.out.println("2- Deposit");
                    System.out.println("3- Balance Inquiry");
                    System.out.println("4- Exit");
                    System.out.print("Choose an option: ");

                    choice = input.nextInt();


                    switch (choice) {
                        case 1:
                            System.out.println("Please enter amount: ");
                            int amount = input.nextInt();
                            if (amount > balance) {
                                System.out.println("Insufficient balance");
                            } else {
                                balance -= amount;
                                System.out.println("Total Balance: " + balance);
                            }
                            break;
                        case 2:
                            System.out.println("Please enter amount: ");
                            int amount2 = input.nextInt();
                            balance += amount2;
                            System.out.println("Total Balance: " + balance);
                            break;
                        case 3:
                            System.out.println("Total Balance: " + balance);
                            break;
                        case 4:
                            System.out.println("Exit.");
                            session = false;
                            right =-1;
                            break;
                        default:
                            System.out.println("Please try again");
                            session = false;
                            break;
                    }
                }
            } else {
                right--;
                System.out.println("Incorrect username or password. Please try again");
                if (right == 0) {
                    System.out.println("You entered your password incorrectly 3 times. Your password has been blocked. Please contact our bank.");
                } else {
                    System.out.println("your remaining entry right " + right);
                }

            }

        }
    }
}
