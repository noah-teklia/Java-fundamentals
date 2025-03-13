package _02_oop_projects._03_inheritance._01_BankAccount;

public class CheckingAccount extends BankAccount {
    int transactionLimit;
    int transactions;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, int transactionLimit) {
        super(accountNumber, accountHolder, balance);
        this.transactionLimit = transactionLimit;
        this.transactions = 0;
    }

    @Override
    public void deposit(double amount) {
        if (transactions < transactionLimit) {
            super.deposit(amount);

        } else {
            System.out.println("Transaction Limit exceeded");
        }
    }
}
