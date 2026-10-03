package abstraction.class_problems.problem_1;

public class CheckoutPaymentHandler {
    static abstract class PaymentMethod {
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

    static class CreditCardPayment extends PaymentMethod {
        private final String lastFour;

        CreditCardPayment(String lastFour) {
            this.lastFour = lastFour;
        }

        @Override
        public String processPayment(double amount) {
            return "Charged $" + amount + " to card ending " + lastFour
                    + " - Txn " + getTransactionId();
        }
    }

    static class CashPayment extends PaymentMethod {
        @Override
        public String processPayment(double amount) {
            return "Received $" + amount + " in cash - Txn " + getTransactionId();
        }
    }

    public static void printConfirmation(PaymentMethod payment, double amount) {
        System.out.println(payment.processPayment(amount));
    }

    public static void test() {
        CreditCardPayment card = new CreditCardPayment("4471");
        PaymentMethod payment = card;
        printConfirmation(payment, 250.0);
    }
}
