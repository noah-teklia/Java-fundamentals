package _01_oop._01_classdesign;

public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccount account1= new BankAccount();
        account1.accountNumber=1234;
        account1.accountHolder="John";
        account1.balance= 4555.5;
        account1.displayInfo();
        account1.deposit(2000);
        account1.withdraw(500);

        BankAccount account2=new BankAccount();
        account2.accountHolder="William";
        account2.accountNumber=65432;
        account2.balance=4500;
        account2.displayInfo();
        account2.deposit(3500);
        account2.withdraw(1000);

    }
}
