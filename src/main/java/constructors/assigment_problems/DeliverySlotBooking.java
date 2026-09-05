package constructors.assigment_problems;
public class DeliverySlotBooking {
    static class DeliverySlot {
        String orderId,timeSlot;
        DeliverySlot(String id,String slot) {
            orderId=id;
            timeSlot=slot;
        }
        DeliverySlot(String id) {
            this(id,"ASAP");
        }
        boolean isPeakHour() {
            return timeSlot.equals("12:00-13:00")||timeSlot.equals("13:00-14:00")||timeSlot.equals("19:00-20:00")||timeSlot.equals("20:00-21:00");
        }
    }
    public static void main(String[]a) {
        System.out.println(new DeliverySlot("ORD101","13:00-14:00").isPeakHour());
        System.out.println(new DeliverySlot("ORD102").isPeakHour());
    }
}
