package _02_oop_projects._03_inheritance._01_BankAccount;

public class PersonalAccount extends BankAccount {
    double maintenanceFee;

    public PersonalAccount(String accountNumber, String accountHolder, double balance, double maintenanceFee) {
        super(accountNumber, accountHolder, balance);
        this.maintenanceFee = maintenanceFee;
    }

    public void deductMaintenanceFee() {
        if(getBalance()>maintenanceFee){
            double previousBalance=getBalance();
            setBalance(getBalance()-maintenanceFee);
            logTransaction("Maintenance Fee", maintenanceFee,previousBalance);
        }else{
            System.out.println("Insufficent Funds to deduct Maintenance Fee");
        }
    }
}
