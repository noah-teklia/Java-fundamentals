package _02_oop_projects._04_polymorphism._01_abstractclasses._01_bankAccount;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BankAccount account;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Choose Account Type:\n" +
                    "1. Savings Account\n" +
                    "2. Current Account");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter Account Holder: ");
            String accountHolder = scanner.nextLine();

            System.out.print("Enter Initial Balance: ");
            double initialBalance = scanner.nextDouble();

            if (choice == 1) {
                System.out.print("Enter Interest Rate (%): ");
                double interestRate = scanner.nextDouble();

                account = new SavingAccount(accountNumber, accountHolder, initialBalance, interestRate);
            } else if (choice == 2) {
                System.out.print("Enter Overdraft Limit: ");
                double overdraftLimit = scanner.nextDouble();

                account = new CurrentAccount(accountNumber, accountHolder, initialBalance, overdraftLimit);


            } else {
                System.out.println("Invalid choice.Please try again");
                continue;
            }

            performTransaction();
        }

    }

    public static void performTransaction(){
        while (true) {
            System.out.println("Options:\n" +
                    "1. Deposit\n" +
                    "2. Withdraw\n" +
                    "3. Display Account Details\n" +
                    "4. Display Account Type\n" +
                    "5. Exit");
            System.out.print("Enter your choice:");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
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
                    displayAccountType();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid option, Please try again");
            }

        }
    }

    public static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amountDeposit = scanner.nextDouble();
        account.deposit(amountDeposit);
    }

    public static void withdraw() {
        System.out.println("Enter amount to withdraw: ");
        double amountWithdrawn = scanner.nextDouble();
        account.withdraw(amountWithdrawn);


    }

    public static void displayAccountDetails() {
        account.displayDetails();

    }

    public static void displayAccountType() {
        account.displayAccountType();

    }

}
