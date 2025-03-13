package _02_oop_projects._04_polymorphism._02_interfaces._04_payment;

public class PaymentProcessor {
    public void processPayment(Payment payment, double amount) {
        payment.makePayment(amount);
    }
}
