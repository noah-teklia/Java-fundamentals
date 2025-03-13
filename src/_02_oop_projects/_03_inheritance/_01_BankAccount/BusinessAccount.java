package _02_oop_projects._03_inheritance._01_BankAccount;

public class BusinessAccount extends BankAccount {
    double creditLimit;

    public BusinessAccount(String accountNumber, String accountHolder, double balance,double creditLimit) {
        super(accountNumber,accountHolder,balance);
        this.creditLimit=creditLimit;
    }


    @Override
    public void withdraw(double amount){
        if((getBalance()+creditLimit)>amount && amount>0){
            double previousBalance=getBalance();
            setBalance(getBalance()-amount);
            logTransaction("Withdraw",amount,previousBalance);
        }else{
            if(amount <0){
                System.out.println("Amount has to be greater than zero");
            }else{
                System.out.println("Withdrawal exceeds balance");
            }
        }


    }
}



