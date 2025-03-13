package _02_oop_projects._04_polymorphism._01_abstractclasses._01_bankAccount;

public class CurrentAccount extends BankAccount {
    double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;

    }

    @Override
    public void displayAccountType() {
        System.out.println("Account type: " + getClass().getSimpleName());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

