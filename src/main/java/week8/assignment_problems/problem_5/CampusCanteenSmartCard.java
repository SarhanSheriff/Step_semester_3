package week8.assignment_problems.problem_5;

import java.util.*;

public class CampusCanteenSmartCard {
    interface PricingPlan {
        double price(double original);
    }

    static class DayScholarPlan implements PricingPlan {
        public double price(double original) {
            return original;
        }
    }

    static class HostellerPlan implements PricingPlan {
        public double price(double original) {
            return original * .90;
        }
    }

    static class StaffPlan implements PricingPlan {
        public double price(double original) {
            return original * .80;
        }
    }

    static class Transaction {
        final double amount;
        final String description;

        Transaction(double amount, String description) {
            this.amount = amount;
            this.description = description;
        }
    }

    static class SmartCard {
        private final String cardId;
        private final PricingPlan plan;
        private final List<Transaction> transactions = new ArrayList<>();
        private double balance;
        private boolean blocked;
        private final Set<String> refunded = new HashSet<>();

        SmartCard(String cardId, PricingPlan plan) {
            this.cardId = cardId;
            this.plan = plan;
        }

        void topUp(double amount) {
            checkActive();

            if (amount < 100) {
                throw new IllegalArgumentException(
                        "Minimum top-up is ₹100");
            }
            if (balance + amount > 5000) {
                throw new IllegalArgumentException(
                        "Maximum balance is ₹5000");
            }

            record(amount, "Top-up");
        }

        void purchase(String item, double originalPrice) {
            checkActive();

            double charged = plan.price(originalPrice);
            if (charged > balance) {
                throw new IllegalStateException("Insufficient balance");
            }

            record(-charged, item);
        }

        void refund(String item, double amount) {
            checkActive();

            if (!refunded.add(item)) {
                throw new IllegalStateException(
                        item + " has already been refunded");
            }

            record(amount, "Refund: " + item);
        }

        void block() {
            blocked = true;
        }

        void unblock() {
            blocked = false;
        }

        String statement() {
            StringBuilder result = new StringBuilder();
            for (Transaction t : transactions) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(String.format("%+.2f", t.amount));
            }
            return result + " = ₹" + String.format("%.2f", balance);
        }

        private void record(double amount, String description) {
            transactions.add(new Transaction(amount, description));
            balance += amount;
        }

        private void checkActive() {
            if (blocked) {
                throw new IllegalStateException("Card is blocked");
            }
        }
    }
}
