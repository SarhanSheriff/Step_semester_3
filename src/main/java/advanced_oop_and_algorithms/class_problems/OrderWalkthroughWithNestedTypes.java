package advanced_oop_and_algorithms.class_problems;

import java.util.Scanner;

public class OrderWalkthroughWithNestedTypes {

    static class Order {
        private LineItem[] items = new LineItem[10];
        private int size;

        static class LineItem {
            String productName;
            int quantity;
            double unitPrice;

            LineItem(String productName, int quantity, double unitPrice) {
                this.productName = productName;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            double total() {
                return quantity * unitPrice;
            }
        }

        class Cursor {
            private int position;

            boolean hasNext() {
                return position < size;
            }

            LineItem next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more line items");
                }
                return items[position++];
            }

            void reset() {
                position = 0;
            }
        }

        void addItem(String productName, int quantity, double unitPrice) {
            if (size == items.length) {
                LineItem[] larger = new LineItem[items.length * 2];
                System.arraycopy(items, 0, larger, 0, size);
                items = larger;
            }

            items[size++] = new LineItem(productName, quantity, unitPrice);
        }

        Cursor cursor() {
            return new Cursor();
        }
    }

    private static String formatAmount(double amount) {
        if (amount == (long) amount) {
            return String.valueOf((long) amount);
        }
        return String.valueOf(amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String product = sc.next();
            int quantity = sc.nextInt();
            double price = sc.nextDouble();
            order.addItem(product, quantity, price);
        }

        Order.Cursor cursor = order.cursor();
        double grandTotal = 0;

        while (cursor.hasNext()) {
            Order.LineItem item = cursor.next();
            System.out.println(item.productName + " " + formatAmount(item.total()));
            grandTotal += item.total();
        }

        System.out.println("Total " + formatAmount(grandTotal));
        System.out.println("cursor: inner (reads the order's array)");
        System.out.println("line item: static nested (needs no order)");

        // Adding an item is O(1) amortized; walking through the order is O(n).
        // The array uses O(n) space, and the cursor itself uses O(1) space.
    }
}
