package abstraction.class_problems.problem_2;

interface Alertable {
    String sendAlert(String message);
}

class SecuritySensor {
    private final String zoneName;

    SecuritySensor(String zoneName) {
        this.zoneName = zoneName;
    }

    String getZoneName() {
        return zoneName;
    }
}

class MotionSensor extends SecuritySensor implements Alertable {
    MotionSensor(String zoneName) {
        super(zoneName);
    }

    @Override
    public String sendAlert(String message) {
        return "[" + getZoneName() + "] " + message;
    }
}

class DualZoneMotionSensor extends MotionSensor {
    private final String secondZone;

    DualZoneMotionSensor(String zoneName, String secondZone) {
        super(zoneName);
        this.secondZone = secondZone;
    }

    @Override
    public String sendAlert(String message) {
        return super.sendAlert(message) + " [also covering " + secondZone + "]";
    }
}

class SmokeDetector implements Alertable {
    private final String deviceId;

    SmokeDetector(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String sendAlert(String message) {
        return "[" + deviceId + "] " + message;
    }
}

public class HomeSafetyAlertNetwork {
    public static void broadcastAll(Alertable[] devices, String message) {
        for (Alertable device : devices) {
            System.out.println(device.sendAlert(message));
        }
    }

    public static String getZoneIfMotionSensor(Alertable device) {
        if (device instanceof MotionSensor) {
            return ((MotionSensor) device).getZoneName();
        }
        return "Not a motion sensor";
    }
}
