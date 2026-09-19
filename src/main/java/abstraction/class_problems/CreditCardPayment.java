package abstraction.class_problems;

public class CreditCardPayment extends PaymentMethod {
    private final String lastFour;

    public CreditCardPayment(String cardNumberLastFour) {
        lastFour = cardNumberLastFour;
    }

    @Override
    public String processPayment(double amount) {
        return "Charged $" + amount + " to card ending " + lastFour
                + " - Txn " + getTransactionId();
    }
}