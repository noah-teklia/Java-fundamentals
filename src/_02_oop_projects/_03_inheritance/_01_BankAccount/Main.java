package _02_oop_projects._03_inheritance._01_BankAccount;

import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    BankAccount bankAccount = null;
//    BusinessAccount businessAccount=null;
//    PersonalAccount personalAccount=null;
//    CheckingAccount checkingAccount=null;
//    SavingAccount savingAccount=null;

    public static void main(String[] args) {
        Main bankSystem = new Main();
        bankSystem.run();


    }

    private void run() {
        System.out.println("Welcome to the Bank System!");
        System.out.println("\n1. Business Account\n" +
                "2. Personal Account\n" +
                "3. Saving Account\n" +
                "4. Checking Account\n" +
                "5. Exit\n");
        System.out.print("Choose an account type:");
        int accountType = input.nextInt();
        input.nextLine();

        switch (accountType) {
            case 1:
                openBusinessAccount();
                break;
            case 2:
                openPersonalAccount();
                break;
            case 3:
                openSavingAccount();
                break;
            case 4:
                openCheckingAccount();
                break;
            case 5:
                System.out.println("Exiting");
                return;
            default:
                System.out.println("Invalid choice.Please try again");


        }

        while (true) {
            System.out.println("1. Deposit Money\n" +
                    "2. Withdraw Money\n" +
                    "3. Display Account Details\n" +
                    "4. Perform Special Action (if applicable)\n" +
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
                    performSpecialAction();
                    break;
                case 5:
                    System.out.println("Exitting");
                    return;
                default:
                    System.out.println("Invalid choice, Please try again");



            }
        }
    }

    private void openBusinessAccount() {
        System.out.print("Enter Account number: ");
        String accountNumber = input.nextLine();

        System.out.print("Enter Account Holder: ");
        String accountHolder = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = input.nextDouble();

        System.out.print("Enter Credit Limit: ");
        double creditLimit = input.nextDouble();

        bankAccount = new BusinessAccount(accountNumber, accountHolder, initialBalance, creditLimit);


    }

    private void openPersonalAccount() {
        System.out.print("Enter Account number: ");
        String accountNumber = input.nextLine();

        System.out.print("Enter Account Holder: ");
        String accountHolder = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = input.nextDouble();

        System.out.print("Enter Maintenance Fee: ");
        double maintenanceFee = input.nextDouble();

        bankAccount = new PersonalAccount(accountNumber, accountHolder, initialBalance, maintenanceFee);


    }

    private void openSavingAccount() {
        System.out.print("Enter Account number: ");
        String accountNumber = input.nextLine();

        System.out.print("Enter Account Holder: ");
        String accountHolder = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = input.nextDouble();

        System.out.print("Enter Interest Rate: ");
        double interestRate = input.nextDouble();

        bankAccount = new SavingAccount(accountNumber, accountHolder, initialBalance, interestRate);

    }

    private void openCheckingAccount() {
        System.out.print("Enter Account number: ");
        String accountNumber = input.nextLine();

        System.out.print("Enter Account Holder: ");
        String accountHolder = input.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = input.nextDouble();

        System.out.println("Enter Transactions Limit: ");
        int transactionLimit = input.nextInt();

        bankAccount = new CheckingAccount(accountNumber, accountHolder, initialBalance, transactionLimit);

    }

    private void deposit() {
        System.out.print("Deposit amount: ");
        double depositedAmount = input.nextDouble();
        bankAccount.deposit(depositedAmount);
    }

    private void withdraw() {
        System.out.print("Withdraw amount: ");
        double withdrewAmount = input.nextDouble();
        bankAccount.withdraw(withdrewAmount);
    }


    private void displayAccountDetails(){
        bankAccount.displayDetails();
    }

    private void performSpecialAction(){
        if(bankAccount instanceof PersonalAccount){
            ((PersonalAccount) bankAccount).deductMaintenanceFee(); // Downcasting
        } else if (bankAccount instanceof SavingAccount) {
            ((SavingAccount)bankAccount).addInterest();

        } else if (bankAccount instanceof CheckingAccount) {
            int transactionLeft=((CheckingAccount)bankAccount).transactionLimit- ((CheckingAccount)bankAccount).transactions;
            System.out.println("Transactions Left: "+ transactionLeft);

        }else{
            System.out.println("No special Transaction for business account");

        }

    }


}
