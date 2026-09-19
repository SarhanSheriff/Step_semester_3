package abstraction.class_problems;

public class CashPayment extends PaymentMethod {
    public CashPayment() {}

    @Override
    public String processPayment(double amount) {
        return "Received $" + amount + " in cash - Txn " + getTransactionId();
    }
}