package abstraction.assignment_problems.problem_5;

public class ConnectedHomeControlPanel {
    static abstract class HomeDevice {
        private static int nextId = 1001;
        private final String serialNumber = "HD-" + nextId++;

        public abstract String activate();

        public String getSerialNumber() {
            return serialNumber;
        }
    }

    interface RemoteControllable {
        String connect(String appId);
    }

    interface EnergyTrackable {
        double getConsumptionWatts();
    }

    static class WashingMachine extends HomeDevice
            implements RemoteControllable, EnergyTrackable {

        private final double consumptionWatts;

        WashingMachine(double consumptionWatts) {
            this.consumptionWatts = consumptionWatts;
        }

        @Override
        public String activate() {
            return "Washing machine " + getSerialNumber() + " started a cycle";
        }

        @Override
        public String connect(String appId) {
            return getSerialNumber() + " connected to " + appId;
        }

        @Override
        public double getConsumptionWatts() {
            return consumptionWatts;
        }
    }

    static class Refrigerator extends HomeDevice
            implements EnergyTrackable {

        private final double consumptionWatts;

        Refrigerator(double consumptionWatts) {
            this.consumptionWatts = consumptionWatts;
        }

        @Override
        public String activate() {
            return "Refrigerator " + getSerialNumber() + " started";
        }

        @Override
        public double getConsumptionWatts() {
            return consumptionWatts;
        }
    }

    static class MobileApp implements RemoteControllable {
        private final String appName;

        MobileApp(String appName) {
            this.appName = appName;
        }

        @Override
        public String connect(String appId) {
            return appName + " connected to " + appId;
        }
    }

    static void connectAll(RemoteControllable[] items, String appId) {
        for (RemoteControllable item : items) {
            System.out.println(item.connect(appId));
        }
    }

    static double getConsumptionIfTrackable(HomeDevice device) {
        if (device instanceof EnergyTrackable) {
            return ((EnergyTrackable) device).getConsumptionWatts();
        }
        return 0;
    }
}
