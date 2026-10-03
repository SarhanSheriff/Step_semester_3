package week8.assignment_problems.problem_3;

import java.util.*;

public class SmartLabControlPanel {
    interface Capability {
        String setValue(double value);
        String name();
    }

    static class PowerCapability implements Capability {
        private boolean on;

        public String setValue(double value) {
            if (value != 0 && value != 1) {
                throw new IllegalArgumentException("Power must be 0 or 1");
            }
            on = value == 1;
            return on ? "ON" : "OFF";
        }

        public String name() {
            return "Power";
        }
    }

    static class BrightnessCapability implements Capability {
        private double brightness;

        public String setValue(double value) {
            if (value < 0 || value > 100) {
                throw new IllegalArgumentException(
                        "Brightness must be between 0 and 100");
            }
            brightness = value;
            return "brightness set to " + brightness + "%";
        }

        public String name() {
            return "Brightness";
        }
    }

    static class TemperatureCapability implements Capability {
        private double temperature;

        public String setValue(double value) {
            if (value < 16 || value > 30) {
                throw new IllegalArgumentException(
                        "Temperature must be between 16°C and 30°C");
            }
            temperature = value;
            return "temperature set to " + temperature + "°C";
        }

        public String name() {
            return "Temperature";
        }
    }

    static class Device {
        final String name;
        private final Map<String, Capability> capabilities = new HashMap<>();

        Device(String name) {
            this.name = name;
        }

        void addCapability(Capability capability) {
            capabilities.put(capability.name(), capability);
        }

        Capability getCapability(String name) {
            return capabilities.get(name);
        }
    }

    static class SceneStep {
        final String capability;
        final double value;

        SceneStep(String capability, double value) {
            this.capability = capability;
            this.value = value;
        }

        boolean apply(Device device) {
            Capability capability = device.getCapability(this.capability);
            if (capability == null) {
                return false;
            }
            System.out.println(device.name + ": "
                    + capability.setValue(value));
            return true;
        }
    }

    static class Scene {
        final String name;
        final List<SceneStep> steps = new ArrayList<>();

        Scene(String name) {
            this.name = name;
        }

        void addStep(SceneStep step) {
            steps.add(step);
        }

        int run(List<Device> devices) {
            int count = 0;
            for (SceneStep step : steps) {
                for (Device device : devices) {
                    if (step.apply(device)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
