package inheritance.class_problems;

import java.time.*;
import java.util.*;

public class HotelBookingSystem {
    interface PricingPlan {
        double pricePerNight();
    }

    static class StandardPlan implements PricingPlan {
        public double pricePerNight() {
            return 150;
        }
    }

    static class DeluxePlan implements PricingPlan {
        public double pricePerNight() {
            return 200;
        }
    }

    static class SuitePlan implements PricingPlan {
        public double pricePerNight() {
            return 300;
        }
    }

    static class Room {
        private final String name;
        private final PricingPlan plan;

        Room(String name, PricingPlan plan) {
            this.name = name;
            this.plan = plan;
        }
    }

    static class Customer {
        private final String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Reservation {
        private final Room room;
        private final Customer customer;
        private final LocalDate start;
        private final LocalDate end;
        private boolean cancelled;

        Reservation(Room room, Customer customer,
                    LocalDate start, LocalDate end) {
            this.room = room;
            this.customer = customer;
            this.start = start;
            this.end = end;
        }

        boolean overlaps(LocalDate from, LocalDate to) {
            return !cancelled && start.isBefore(to) && from.isBefore(end);
        }

        double price() {
            return Duration.between(
                    start.atStartOfDay(), end.atStartOfDay()).toDays()
                    * room.plan.pricePerNight();
        }

        void cancel() {
            cancelled = true;
        }
    }

    static class Hotel {
        private final List<Room> rooms = new ArrayList<>();
        private final List<Reservation> reservations = new ArrayList<>();

        void addRoom(Room room) {
            rooms.add(room);
        }

        Reservation book(Room room, Customer customer,
                         LocalDate start, LocalDate end) {
            for (Reservation r : reservations) {
                if (r.room == room && r.overlaps(start, end)) {
                    throw new IllegalStateException("Room is not available");
                }
            }

            Reservation reservation =
                    new Reservation(room, customer, start, end);
            reservations.add(reservation);
            return reservation;
        }

        void cancel(Reservation reservation, LocalDate now) {
            if (!now.isBefore(reservation.start)) {
                throw new IllegalStateException(
                        "Cancellation deadline has passed");
            }
            reservation.cancel();
        }
    }
}
