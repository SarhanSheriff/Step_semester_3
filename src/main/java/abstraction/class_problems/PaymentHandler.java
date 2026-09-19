package abstraction.class_problems;

public class PaymentHandler {
    public static void printConfirmation(PaymentMethod payment, double amount) {
        System.out.println(payment.processPayment(amount));
    }

    public static void test() {
        CreditCardPayment cc = new CreditCardPayment("4471");
        PaymentMethod ref = cc; // upcasting
        printConfirmation(ref, 250.0);
    }
}