package abstraction.assignment_problems.problem_3;

public class FleetMaintenanceTracker {
    static abstract class ServiceableVehicle {
        private double mileage;

        public abstract String performMaintenance();

        public double getMileage() {
            return mileage;
        }

        public void addMileage(double km) {
            if (km < 0) {
                throw new IllegalArgumentException("Mileage cannot be negative");
            }
            mileage += km;
        }
    }

    interface Insurable {
        String getInsuranceInfo();
    }

    static class Forklift extends ServiceableVehicle implements Insurable {
        private final String assetTag;

        Forklift(String assetTag) {
            this.assetTag = assetTag;
        }

        @Override
        public String performMaintenance() {
            return "Forklift " + assetTag
                    + ": hydraulic and fork inspection complete";
        }

        @Override
        public String getInsuranceInfo() {
            return "Insured under fleet policy - Asset " + assetTag;
        }
    }

    static class HeavyDutyForklift extends Forklift {
        HeavyDutyForklift(String assetTag) {
            super(assetTag);
        }

        @Override
        public String performMaintenance() {
            return super.performMaintenance()
                    + " | high-pressure hydraulic check complete";
        }
    }

    static String getInsuranceIfApplicable(ServiceableVehicle vehicle) {
        if (vehicle instanceof Insurable) {
            return ((Insurable) vehicle).getInsuranceInfo();
        }
        return "No insurance record exists";
    }
}
