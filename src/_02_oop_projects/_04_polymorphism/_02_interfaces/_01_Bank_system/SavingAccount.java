package _02_oop_projects._04_polymorphism._02_interfaces._01_Bank_system;

public class SavingAccount extends BankAccount implements AccountOperations {
    double interestRate;

    public SavingAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    @Override
    public void displayAccountType(){
        System.out.println("Account Type: "+getClass());

    }
    @Override
    public void displayAccountDetails(){
        displayAccountType();
        super.displayDetails();
        System.out.println("Interest Rate: "+interestRate);

    }
    @Override
    public void calculateAnnualInterest(){
        double annualInterestRate=(interestRate/100)*balance;
        System.out.println("Annual Interest Rate: "+annualInterestRate);


    }
}
