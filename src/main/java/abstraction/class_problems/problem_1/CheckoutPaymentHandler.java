package abstraction.class_problems.problem_1;

abstract class PaymentMethod {
    private static int nextId = 1001;
    private final String transactionId = "TXN-" + nextId++;

    public abstract String processPayment(double amount);

    public String processPayment(double amount, String note) {
        return processPayment(amount) + " (" + note + ")";
    }

    public String getTransactionId() {
        return transactionId;
    }
}

class CreditCardPayment extends PaymentMethod {
    private final String lastFour;

    CreditCardPayment(String lastFour) {
        this.lastFour = lastFour;
    }

    @Override
    public String processPayment(double amount) {
        return "Charged $" + amount + " to card ending "
                + lastFour + " - Txn " + getTransactionId();
    }
}

class CashPayment extends PaymentMethod {
    @Override
    public String processPayment(double amount) {
        return "Received $" + amount
                + " in cash - Txn " + getTransactionId();
    }
}

public class CheckoutPaymentHandler {
    public static void printConfirmation(PaymentMethod payment, double amount) {
        System.out.println(payment.processPayment(amount));
    }

    public static void test() {
        printConfirmation(new CreditCardPayment("4471"), 250.0);
    }
}
