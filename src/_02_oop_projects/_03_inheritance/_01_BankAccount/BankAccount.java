package _02_oop_projects._03_inheritance._01_BankAccount;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }


    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber ){
        this.accountNumber=accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            double previousBalance=balance;
            balance += amount;
            logTransaction("Deposit", amount,previousBalance);

        } else {
            System.out.println("Deposit amount should be greater than zero");
        }

    }

    public void withdraw(double amount) {
        if (balance > amount && amount > 0) {
            double previousBalance=balance;
            balance -= amount;
            logTransaction("Withdraw", amount,previousBalance);

        } else {
            if (balance < amount) {
                System.out.println("Balance should be greater than the amount");
            } else {
                System.out.println("Amount should be greater than zero ");
            }
        }

    }

    public void displayDetails() {
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);

    }

    protected void logTransaction(String operation, double amount,double previousBalance) {
        System.out.println(operation + " Amount: $" + amount);
        System.out.println("Previous Balance: $" + previousBalance);
        System.out.println("Current Balance: $" + (balance));
        System.out.println("Sending SMS message to "+ accountHolder);
        System.out.println("Sending Email  to "+ accountHolder);
        System.out.println("Sending Whatsapp message to "+ accountHolder);

    }
}
