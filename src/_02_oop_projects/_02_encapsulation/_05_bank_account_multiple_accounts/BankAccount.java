package _02_oop_projects._02_encapsulation._05_bank_account_multiple_accounts;


public class BankAccount {
     String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.setAccountHolder(accountHolder);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        showCurrentBalance(amount,"Deposited");

    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            showCurrentBalance(amount, "Withdraw");
        }

    }

    public void displayDetail() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    private void showCurrentBalance(double amount, String message) {

        System.out.println(message + ": $" + amount);
        System.out.println("Current Balance: $" + balance);
    }

}
