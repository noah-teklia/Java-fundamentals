package _02_oop_projects._01_basic._05_bank_account_multiple_accounts;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static BankAccount[] accounts = new BankAccount[5];
    static int accountCount = 0;


    public static void main(String[] args) {

        System.out.println("Welcome to Accounts System");;

        while(true) {
            System.out.println("1. Add Bank Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addAccount() {
        if(accountCount < accounts.length) {
            // Add account
            System.out.print("Enter Account Number: ");
            String accountNumber = input.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String accountHolder = input.nextLine();

            System.out.print("Enter Initial Balance: ");
            double initialBalance = input.nextDouble();
            input.nextLine();

            BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance);

            accounts[accountCount] = newAccount;
            accountCount++;
            System.out.println("Account added successfully!");

        } else {
            System.out.println("Account limit is reached.");
        }

    }

    private static void viewAllAccounts() {
        if(accountCount > 0) {
            // Display accounts details
            for (int i = 0; i < accountCount; i++) {
                System.out.println("\nAccount " + (i + 1) + ":");
                accounts[i].displayDetail();

            }
        } else {
            System.out.println("No accounts available to display.");
        }

    }

    private static void deposit() {
        System.out.print("Enter your account number: ");
        String accountNumber = input.nextLine();

        BankAccount account = findAccountByAccountNumber(accountNumber);

        if(account != null) {
            // Deposit operation
            System.out.print("Enter amount to deposit: ");
            double amount = input.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account does not exist.");
        }

    }

    private static void withdraw() {
        System.out.print("Enter your account number: ");
        String accountNumber = input.nextLine();

        BankAccount account = findAccountByAccountNumber(accountNumber);

        if(account != null) {
            // Withdraw operation
            System.out.print("Enter amount to withdraw: ");
            double amount = input.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account does not exist.");
        }


    }

    private static void viewAccountDetails() {
        System.out.print("Enter your account number: ");
        String accountNumber = input.nextLine();

        BankAccount account = findAccountByAccountNumber(accountNumber);

        if(account != null) {
            account.displayDetail();
        } else {
            System.out.println("Account does not exist.");
        }



    }

    private static BankAccount findAccountByAccountNumber(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if(accounts[i].accountNumber.equals(accountNumber)) {
                return accounts[i];
            }

        }
        return null;
    }
}