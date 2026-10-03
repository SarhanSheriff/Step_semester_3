package inheritance.class_problems;

import java.util.*;

public class FoodOrderPaymentSystem {
    interface PaymentMethod {
        boolean pay(double amount);
        String name();
    }

    static class CreditCardPayment implements PaymentMethod {
        public boolean pay(double amount) {
            return true;
        }

        public String name() {
            return "Credit Card";
        }
    }

    static class DigitalWalletPayment implements PaymentMethod {
        private final boolean succeeds;

        DigitalWalletPayment(boolean succeeds) {
            this.succeeds = succeeds;
        }

        public boolean pay(double amount) {
            return succeeds;
        }

        public String name() {
            return "Digital Wallet";
        }
    }

    static class CashOnDelivery implements PaymentMethod {
        public boolean pay(double amount) {
            return true;
        }

        public String name() {
            return "Cash on Delivery";
        }
    }

    static class FoodItem {
        final String name;
        final double price;

        FoodItem(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class LineItem {
        final FoodItem item;
        final int quantity;

        LineItem(FoodItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        double total() {
            return item.price * quantity;
        }
    }

    static class Customer {
        final String name;

        Customer(String name) {
            this.name = name;
        }

        void notifyCustomer(String message) {
            System.out.println("Notification: " + message);
        }
    }

    static class Order {
        private final Customer customer;
        private final List<LineItem> items = new ArrayList<>();
        private String status = "Created";

        Order(Customer customer) {
            this.customer = customer;
        }

        void addItem(FoodItem item, int quantity) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
            items.add(new LineItem(item, quantity));
        }

        double total() {
            return items.stream().mapToDouble(LineItem::total).sum();
        }

        boolean place(PaymentMethod payment) {
            if (items.isEmpty()) {
                throw new IllegalStateException(
                        "Order must contain at least one item");
            }

            status = "Placed";
            customer.notifyCustomer("Order placed");

            if (payment.pay(total())) {
                status = "Paid";
                customer.notifyCustomer(
                        "Payment Successful via " + payment.name());
                return true;
            }

            status = "Pending Payment";
            customer.notifyCustomer(
                    "Payment failed via " + payment.name());
            return false;
        }

        String getStatus() {
            return status;
        }
    }
}
