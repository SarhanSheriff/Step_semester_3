package advanced_oop_and_algorithms.class_problems;
import java.util.Scanner;
public class RideFareEngine {
    static abstract class Ride {
        double distance;
        Ride(double distance) { this.distance = distance; }
        abstract double calculateFare();
        abstract String getType();
    }
    static class Auto extends Ride {
        Auto(double distance) { super(distance); }
        double calculateFare() { return 30 + 15 * distance; }
        String getType() { return "Auto"; }
    }
    static class Cab extends Ride {
        double surge;
        Cab(double distance, double surge) { super(distance); this.surge = surge; }
        double calculateFare() { return (50 + 20 * distance) * surge; }
        String getType() { return "Cab"; }
    }
    static class Bike extends Ride {
        int waitingMinutes;
        Bike(double distance, int waitingMinutes) {
            super(distance);
            this.waitingMinutes = waitingMinutes;
        }
        double calculateFare() { return 20 + 10 * distance + 2 * waitingMinutes; }
        String getType() { return "Bike"; }
    }
    private static String formatAmount(double amount) {
        if (amount == (long) amount) return String.valueOf((long) amount);
        return String.valueOf(amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ride[] rides = new Ride[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            if (type.equalsIgnoreCase("Auto")) rides[i] = new Auto(distance);
            else if (type.equalsIgnoreCase("Cab")) rides[i] = new Cab(distance, sc.nextDouble());
            else if (type.equalsIgnoreCase("Bike")) rides[i] = new Bike(distance, sc.nextInt());
        }
        double total = 0;
        for (Ride ride : rides) {
            double fare = ride.calculateFare();
            System.out.println(ride.getType() + ": " + formatAmount(fare));
            total += fare;
        }
        System.out.println("Total: " + formatAmount(total));
        // Pricing all rides takes O(n) time.
    }
}