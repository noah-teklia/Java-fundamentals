package _02_oop_projects._04_polymorphism._02_interfaces._04_payment;

public class CheckPayment implements Payment{
    private String payeeName;
    private String signature;

    public CheckPayment(String payeeName, String signature) {
        this.payeeName = payeeName;
        this.signature = signature;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing check Payment: " + amount);
        System.out.println("Payee Name" + payeeName + ", Signature: " + signature);
    }
}
