package _02_oop_projects._04_polymorphism._02_interfaces._01_Bank_system;

public abstract class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public abstract void displayAccountType();

    public void deposit(double amount) {
        if (amount >= 0) {
            double previousBalance = balance;
            balance += amount;
            System.out.println("Deposited amount: " + amount);
            System.out.println("Old balance: " + previousBalance);
            System.out.println("Current balance: " + balance);

        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount >= 0 && balance > amount) {
            double previousBalance = balance;
            balance -= amount;
            System.out.println("Withdrew amount: " + amount);
            System.out.println("Old balance: " + previousBalance);
            System.out.println("Current balance: " + balance);

        }else{
            System.out.println("Amount must be less than the balance to withdraw");
        }

    }

    public void displayDetails(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Balance: "+balance);
    }
}
