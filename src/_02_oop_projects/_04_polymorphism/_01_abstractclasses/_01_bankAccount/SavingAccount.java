package _02_oop_projects._04_polymorphism._01_abstractclasses._01_bankAccount;

public class SavingAccount extends BankAccount {
    double interestRate;

    public SavingAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account type: " + this.getClass().getSimpleName());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate);

    }
}
