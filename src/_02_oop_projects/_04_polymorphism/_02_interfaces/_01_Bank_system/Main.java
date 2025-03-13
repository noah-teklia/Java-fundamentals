package _02_oop_projects._04_polymorphism._02_interfaces._01_Bank_system;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static AccountOperations account;


    public static void main(String[] args) {
            try {
                while (true) {
                    System.out.println("Choose Account Type:\n" +
                            "1. Savings Account\n" +
                            "2. Current Account\n" +
                            "3. Exit");

                    System.out.print("Enter your choice: ");
                    int choice = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Account Number: ");
                    String accountNumber = input.nextLine();

                    System.out.print("Enter Account Holder: ");
                    String accountHolder = input.nextLine();

                    double initialbalance=0;
                   while (true){
                       try {
                           System.out.print("Enter Initial Balance: ");
                           initialbalance = input.nextDouble();
                           break;
                       } catch (Exception e) {
                           System.out.println("Please enter a valid amount");
                           continue;

                       }finally {
                           input.nextLine();
                       }
                   }

                    if (choice == 1) {
                        System.out.print("Enter Interest Rate: ");
                        double interestRate = input.nextDouble();
                        account = new SavingAccount(accountNumber, accountHolder, initialbalance, interestRate);
                        System.out.println("Saving Account created successfully");

                    } else if (choice == 2) {
                        System.out.print("Enter Overdraft Limit: ");
                        double overdraftLimit = input.nextDouble();
                        account = new CurrentAccount(accountNumber, accountHolder, initialbalance, overdraftLimit);
                        System.out.println("Current Account created successfully");

                    } else if (choice == 3) {
                        System.out.println("Exit");
                        return;

                    } else {
                        System.out.println("invalid choice.Try again");
                    }

                    performOperations();

                }
            } catch (Exception e) {
                System.out.println("Invalid choice, Please put integer number");
            }



    }

    public static void performOperations() {
        while (true) {
            System.out.println("Options:\n" +
                    "1. Deposit\n" +
                    "2. Withdraw\n" +
                    "3. Display Account Details\n" +
                    "4. Calculate Annual Interest\n" +
                    "5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    displayAccountDetails();
                    break;
                case 4:
                    calculateAnnualInterest();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amountToDeposit = input.nextDouble();
        ((BankAccount) account).deposit(amountToDeposit);


    }

    public static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amountToWithdraw = input.nextDouble();
        ((BankAccount) account).withdraw(amountToWithdraw);


    }

    public static void displayAccountDetails() {
        account.displayAccountDetails();

    }

    public static void calculateAnnualInterest() {
        account.calculateAnnualInterest();

    }
}
