package com.BankAtm;

import java.util.Scanner;

public class MyBankAtm {

    /* these are global variables(class level variables). Meaning that they possess
     the static key word in order to make them accessible by all the methods within the class.
      */
    static double balance = 900_000;
    static double newDeposit;
    static double newWithDraw;


    // check balance method
    public static void checkBalance() {
        System.out.println("You currently have $" + balance);
    }

    // deposit method
    public static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to deposit? : ");
        newDeposit = sc.nextInt();
        balance = balance + newDeposit;
        System.out.println("You have deposited $" + newDeposit);
        System.out.println("Your current balance is : $" + balance);

    }

    //withdraw method
    public static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to withdraw? : ");
        newWithDraw = sc.nextInt();
        balance = balance - newWithDraw;
        System.out.println("You withdrew: $" + newWithDraw);
        System.out.println("Your remaining balance is : " + balance);
    }

    // another Transaction Method
    public static void anotherTrans() {
        System.out.println("Would you like to make another transaction? Enter 1 for Yes. Enter 2 for No ");

        Scanner scanner = new Scanner(System.in);
        int oneMoreTrans;

        do {
            oneMoreTrans = scanner.nextInt();

            if (oneMoreTrans == 1) {
                scannerMethod();
            } else if (oneMoreTrans == 2) {
                System.out.println("Thank you for banking with chase. Have a good day!");
            } else {
                System.out.println("Please select 1 for YeS, or 2 for No.");
            }
        }
        while (oneMoreTrans != 1 && oneMoreTrans != 2);


    }

    /* scanner method (this method will initiate the user pin log in and  call our other banking methods
        depending on what the user inputs)
     */
    public static void scannerMethod() {

        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.print("Enter 4 digit pin: ");
            input = scanner.nextInt();
            if (input != 9995) {
                System.out.println("The pin is incorrect, please try again.");
            }
        }
        while (input != 9995);
        /* three functions balance() withdraw() deposit()*/
        System.out.println("Enter the associated number to check: balance(1) withdraw(2) or deposit(3)");

        int userInput;
        // the do while loop here is meant to loop until the user makes the correct entry to call one of the banking methods
        do {
            userInput = scanner.nextInt();

            if (userInput == 1) {
                checkBalance();
            } else if (userInput == 2) {
                withdraw();
            } else if (userInput == 3) {
                deposit();
            } else {
                System.out.println("Please make the appropriate selection. ");
            }
        }
        while (userInput != 1 && userInput != 2 && userInput != 3);

        // once an appropriate selection is made the do while loop exits then the another transaction method is called.
        anotherTrans();

    }


    public static void main(String[] args) {
        //This calls the scanner method which will enable the user to enter a pin and select a function of the bank atm.
        scannerMethod();
    }

}
