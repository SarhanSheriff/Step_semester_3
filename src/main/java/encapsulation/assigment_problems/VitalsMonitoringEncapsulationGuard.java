package encapsulation.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class VitalsMonitoringEncapsulationGuard {
    static class PatientVitals {
        private final List<Double> readings = new ArrayList<>();

        PatientVitals(double[] initialReadings) {
            if (initialReadings != null) {
                for (double reading : initialReadings) {
                    recordReading(reading);
                }
            }
        }

        void recordReading(double reading) {
            if (reading > 0 && reading <= 45) {
                readings.add(reading);
            }
        }

        double getAverage() {
            if (readings.isEmpty()) {
                return 0.0;
            }

            double total = 0.0;
            for (double reading : readings) {
                total += reading;
            }
            return total / readings.size();
        }

        double[] getAllReadings() {
            double[] copy = new double[readings.size()];
            for (int i = 0; i < readings.size(); i++) {
                copy[i] = readings.get(i);
            }
            return copy;
        }
    }

    public static void main(String[] args) {
        PatientVitals vitals = new PatientVitals(
                new double[] {36.5, -2, 37.1});

        double[] copy = vitals.getAllReadings();
        copy[0] = 999;

        for (double reading : vitals.getAllReadings()) {
            System.out.println(reading);
        }
    }
}
