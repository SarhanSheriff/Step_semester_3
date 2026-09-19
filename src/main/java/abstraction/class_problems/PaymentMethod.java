package abstraction.class_problems;

public abstract class PaymentMethod {
    private static int nextId = 1001;
    private final String transactionId;

    protected PaymentMethod() {
        transactionId = "TXN-" + nextId++;
    }

    public abstract String processPayment(double amount);

    public String processPayment(double amount, String note) {
        return processPayment(amount) + " (" + note + ")";
    }

    public String getTransactionId() {
        return transactionId;
    }
}