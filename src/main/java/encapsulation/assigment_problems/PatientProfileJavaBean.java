package encapsulation.assigment_problems;

public class PatientProfileJavaBean {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPinHash;

    public PatientProfileJavaBean() {
        this(null, null);
    }

    public PatientProfileJavaBean(String name) {
        this(null, name);
    }

    public PatientProfileJavaBean(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String id) {
        if (patientId == null && id != null) {
            patientId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setLockerPin(String pin) {
        if (pin == null || !pin.matches("\\d{4,6}")) {
            return;
        }
        lockerPinHash = Integer.toHexString(pin.hashCode());
    }

    public static void main(String[] args) {
        PatientProfileJavaBean profile = new PatientProfileJavaBean();
        profile.setPatientId("MT2026-0142");
        profile.setPatientId("HACKED-0000");

        System.out.println(profile.getPatientId());
    }
}
