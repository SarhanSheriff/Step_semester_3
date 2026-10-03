package abstraction.class_problems.problem_2;

public class HomeSafetyAlertNetwork {
    interface Alertable {
        String sendAlert(String message);
    }

    static class SecuritySensor {
        private final String zoneName;

        SecuritySensor(String zoneName) {
            this.zoneName = zoneName;
        }

        String getZoneName() {
            return zoneName;
        }
    }

    static class MotionSensor extends SecuritySensor implements Alertable {
        MotionSensor(String zoneName) {
            super(zoneName);
        }

        @Override
        public String sendAlert(String message) {
            return "[" + getZoneName() + "] " + message;
        }
    }

    static class DualZoneMotionSensor extends MotionSensor {
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

    static class SmokeDetector implements Alertable {
        private final String deviceId;

        SmokeDetector(String deviceId) {
            this.deviceId = deviceId;
        }

        @Override
        public String sendAlert(String message) {
            return "[" + deviceId + "] " + message;
        }
    }

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
