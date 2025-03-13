package _02_oop_projects._04_polymorphism._01_abstractclasses._01_bankAccount;

public abstract class BankAccount {
    String accountNumber;
    String name;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void displayAccountType();

    public void deposit(double amount) {
        if (amount > 0) {
            double oldBalance = balance;
            balance += amount;
            logTransaction("Deposited", amount, oldBalance);

        } else {
            System.out.println("Invalid amount ");
        }


    }

    public void withdraw(double amount) {
        if (amount > 0 && balance > amount) {
            double oldBalance;
            oldBalance = balance;
            balance -= amount;
            logTransaction("Withdrawn", amount, oldBalance);

        } else {
            System.out.println("Invalid amount");
        }

    }

    public void displayDetails(){
        System.out.println("Account number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Balance: "+balance);

    }

    private void logTransaction(String action, double amount, double oldBalance) {
        System.out.println(action + ": $" + amount);
        System.out.println("Old Balance: $" + oldBalance);
        System.out.println("New Balance: $" + balance);
    }

}
