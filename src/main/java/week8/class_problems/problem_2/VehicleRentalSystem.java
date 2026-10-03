package week8.class_problems.problem_2;

import java.util.*;

public class VehicleRentalSystem {
    static abstract class Vehicle {
        private final String name;
        private boolean available = true;

        Vehicle(String name) {
            this.name = name;
        }

        abstract double calculateCharge(int days);

        String getName() {
            return name;
        }

        boolean isAvailable() {
            return available;
        }

        void setAvailable(boolean available) {
            this.available = available;
        }
    }

    static class StandardCar extends Vehicle {
        StandardCar(String name) {
            super(name);
        }

        double calculateCharge(int days) {
            return 50 * days;
        }
    }

    static class LuxuryCar extends Vehicle {
        LuxuryCar(String name) {
            super(name);
        }

        double calculateCharge(int days) {
            return 100 * days;
        }
    }

    static class SUV extends Vehicle {
        SUV(String name) {
            super(name);
        }

        double calculateCharge(int days) {
            return 75 * days;
        }
    }

    static class Rental {
        private final Vehicle vehicle;
        private final int days;
        private final double charge;

        Rental(Vehicle vehicle, int days) {
            this.vehicle = vehicle;
            this.days = days;
            this.charge = vehicle.calculateCharge(days);
        }
    }

    static class RentalService {
        private final List<Rental> rentals = new ArrayList<>();

        Rental rent(Vehicle vehicle, int days) {
            if (!vehicle.isAvailable()) {
                throw new IllegalStateException("Vehicle is already rented");
            }

            vehicle.setAvailable(false);
            Rental rental = new Rental(vehicle, days);
            rentals.add(rental);
            return rental;
        }

        void returnVehicle(Vehicle vehicle) {
            vehicle.setAvailable(true);
        }
    }
}
