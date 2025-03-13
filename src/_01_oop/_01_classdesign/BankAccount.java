package _01_oop._01_classdesign;

public class BankAccount {
    /*
    Bank Account
Objective: Model a simple bank account.

Requirements:

Attributes: accountNumber, accountHolder, and balance.
Methods:
deposit(amount) to add amount to balance.
withdraw(amount) to deduct amount from balance if sufficient funds exist.
displayBalance() to show the current balance.

 Account Holder: John Doe
Initial Balance: 1000
Deposited 500
Withdrawn 300
Current Balance: 1200
     */
    public int accountNumber;
    public String accountHolder;
    public double balance;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();

    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            System.out.println("Withdraw: " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }


    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayInfo() {
        System.out.println("AccountHolder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

}
