package inheritance.assignment_problems;

import java.util.*;

public class SwiftShipParcelTracker {
    interface ShippingType {
        double charge(double kg);
    }

    static class StandardShipping implements ShippingType {
        public double charge(double kg) {
            return 40 + 10 * kg;
        }
    }

    static class ExpressShipping implements ShippingType {
        public double charge(double kg) {
            return 80 + 15 * kg;
        }
    }

    static class FragileShipping implements ShippingType {
        private final ShippingType standard = new StandardShipping();

        public double charge(double kg) {
            return standard.charge(kg) + 50;
        }
    }

    interface NotificationChannel {
        void notify(String parcelId, String status);
    }

    static class SmsChannel implements NotificationChannel {
        public void notify(String id, String status) {
            System.out.println("[SMS] " + id + " is now " + status);
        }
    }

    static class EmailChannel implements NotificationChannel {
        public void notify(String id, String status) {
            System.out.println("[Email] " + id + " is now " + status);
        }
    }

    enum Status {
        BOOKED, PICKED_UP, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED
    }

    static class Customer {
        final String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Parcel {
        private final String id;
        private final double kg;
        private final ShippingType shipping;
        private final List<NotificationChannel> channels = new ArrayList<>();
        private Status status = Status.BOOKED;

        Parcel(String id, double kg, ShippingType shipping) {
            this.id = id;
            this.kg = kg;
            this.shipping = shipping;
        }

        double charge() {
            return shipping.charge(kg);
        }

        void subscribe(NotificationChannel channel) {
            channels.add(channel);
        }

        void moveTo(Status next) {
            if (next.ordinal() != status.ordinal() + 1) {
                throw new IllegalStateException(
                        "Invalid transition: " + status + " → " + next);
            }
            status = next;
            notifyAllChannels();
        }

        void cancel() {
            if (status != Status.BOOKED) {
                throw new IllegalStateException(
                        id + " can be cancelled only while BOOKED");
            }
            status = null;
        }

        private void notifyAllChannels() {
            for (NotificationChannel channel : channels) {
                channel.notify(id, status.name());
            }
        }
    }
}
