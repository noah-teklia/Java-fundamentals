package _02_oop_projects._04_polymorphism._02_interfaces._01_Bank_system;

public class CurrentAccount extends BankAccount implements AccountOperations {
    double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;

    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: " + getClass().getSimpleName());
    }

    @Override
    public void displayAccountDetails() {
        displayAccountType();
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }

    public void calculateAnnualInterest() {
        System.out.println("There is no Annual Interest Calculation");
    }
}
