package encapsulation.class_problems;

import java.util.*;

public class VitalsMonitoringEncapsulationGuard {

    static class PatientVitals {
        private final List<Double> readings = new ArrayList<>();

        PatientVitals(double[] initial) {
            if (initial != null) {
                for (double x : initial) {
                    recordReading(x);
                }
            }
        }

        void recordReading(double r) {
            if (r > 0 && r <= 45) {
                readings.add(r);
            }
        }

        double getAverage() {
            if (readings.isEmpty()) {
                return 0;
            }

            double s = 0;
            for (double x : readings) {
                s += x;
            }
            return s / readings.size();
        }

        double[] getAllReadings() {
            double[] a = new double[readings.size()];
            for (int i = 0; i < a.length; i++) {
                a[i] = readings.get(i);
            }
            return a;
        }
    }

    public static void main(String[] a) {
        PatientVitals v = new PatientVitals(new double[] {36.5, -2, 37.1});
        System.out.println(Arrays.toString(v.getAllReadings()));
    }
}
