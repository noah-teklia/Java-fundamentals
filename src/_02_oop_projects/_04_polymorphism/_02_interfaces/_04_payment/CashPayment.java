package _02_oop_projects._04_polymorphism._02_interfaces._04_payment;

public class CashPayment implements Payment {
    private String name;
    private String idNumber;

    public CashPayment(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing cash Payment: " + amount);
        System.out.println("Name" + name + ", ID number: " + idNumber);

    }
}
