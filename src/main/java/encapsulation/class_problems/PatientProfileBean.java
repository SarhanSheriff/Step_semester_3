package encapsulation.class_problems;

public class PatientProfileBean {

    static class PatientProfile {
        private String patientId;
        private String name;
        private String lockerPinHash;
        private boolean discharged;

        public PatientProfile() {
            this(null, null);
        }

        public PatientProfile(String name) {
            this(null, name);
        }

        public PatientProfile(String id, String name) {
            this.patientId = id;
            this.name = name;
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String id) {
            if (patientId == null) {
                patientId = id;
            }
        }

        public boolean isDischarged() {
            return discharged;
        }

        public void setDischarged(boolean d) {
            discharged = d;
        }

        public void setLockerPin(String pin) {
            if (pin != null && pin.matches("\\d{4,6}")) {
                lockerPinHash = Integer.toHexString(pin.hashCode());
            }
        }
    }

    public static void main(String[] a) {
        PatientProfile p = new PatientProfile();
        p.setPatientId("MT2026-0142");
        p.setPatientId("HACKED-0000");
        System.out.println(p.getPatientId());
    }
}
