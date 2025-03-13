package _02_oop_projects._03_inheritance._01_BankAccount;

public class SavingAccount extends BankAccount {
    double interestRate;

    public SavingAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest;
        double previousBalance=getBalance();
        interest = getBalance() * (interestRate / 100);
        setBalance(getBalance() + interest);
        logTransaction("Added Interest", interest,previousBalance);

    }

}
