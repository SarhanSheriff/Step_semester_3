package advanced_oop_and_algorithms.class_problems;
public class CampusMapPins {
    static class CampusPin {
        public static String banner = "Campus";
        public String name = "General Pin";
        public String getDetails() { return "Details: " + name; }
    }
    static class HostelPin extends CampusPin {
        public static String banner = "Hostel";
        public String name = "Hostel Pin";
        @Override
        public String getDetails() { return "Details: " + name; }
    }
    public static void main(String[] args) {
        CampusPin p = new HostelPin();
        System.out.println("banner: " + p.banner + " (decided by reference type)");
        System.out.println("name: " + p.name + " (decided by reference type)");
        System.out.println(p.getDetails() + " (decided by object type)");
        // Static fields and instance fields are resolved at compile time.
        // Overridden instance methods are selected at run time.
    }
}