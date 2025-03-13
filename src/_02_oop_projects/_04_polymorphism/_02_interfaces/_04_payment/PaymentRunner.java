package _02_oop_projects._04_polymorphism._02_interfaces._04_payment;

public class PaymentRunner {
    public static void main(String[] args) {
        Payment cashPayment = new CashPayment("Noah", "209111");
        //cashPayment.makePayment(2000);


        Payment checkPayment = new CheckPayment("Temie", "TEMESGEN");
        //checkPayment.makePayment(5000);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(cashPayment, 2000);

        paymentProcessor.processPayment(checkPayment, 5000);

    }
}
