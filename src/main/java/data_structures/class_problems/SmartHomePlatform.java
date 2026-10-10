package data_structures.class_problems;

class SmartDevice {
    String id;
    boolean on;

    SmartDevice(String id) { this.id = id; }
    void turnOn() { on = true; System.out.println(id + " is ON"); }
    void turnOff() { on = false; System.out.println(id + " is OFF"); }
}

class SmartLight extends SmartDevice {
    SmartLight(String id) { super(id); }
    void dim(int level) { System.out.println(id + " dimmed to " + level); }
    void schedule(String time) { System.out.println(id + " scheduled " + time); }
}

class SmartFan extends SmartDevice {
    SmartFan(String id) { super(id); }
    void schedule(String time) { System.out.println(id + " scheduled " + time); }
}

class SmartPlug extends SmartDevice {
    int energy;
    SmartPlug(String id, int energy) { super(id); this.energy = energy; }
    void showEnergy() { System.out.println(id + " energy " + energy + " kWh"); }
}

public class SmartHomePlatform {
    public static void main(String[] args) {
        SmartLight light = new SmartLight("L1");
        SmartFan fan = new SmartFan("F1");
        SmartPlug plug = new SmartPlug("P1", 12);
        light.turnOn();
        light.dim(40);
        System.out.println("F1 rejected: DIM unsupported");
        fan.schedule("22:00");
        plug.showEnergy();
        System.out.println("L1 rejected: ENERGY unsupported");
    }
}