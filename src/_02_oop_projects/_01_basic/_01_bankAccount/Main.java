package _02_oop_projects._01_basic._01_bankAccount;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();


        System.out.print("Enter Account Holder: ");
        String accountHolder = scanner.nextLine();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        BankAccount bankAccount = new BankAccount(accountNumber, accountHolder, balance);
        bankAccount.displayDetail();

        while (true) {
            System.out.println("1.Deposit ");
            System.out.println("2.Withdraw");
            System.out.println("3.Display Details");
            System.out.println("4.Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Deposited Amount:");
                    double amount = scanner.nextDouble();
                    bankAccount.deposit(amount);
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double amountToWithDraw = scanner.nextDouble();
                    bankAccount.withdraw(amountToWithDraw);
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.print("Displaying account details: ");
                    bankAccount.displayDetail();
                    break;

                case 4:
                    System.out.print("Exitting...");
                    return;
                default:
                    System.out.println("Invalid Input");


            }

        }


    }
}
