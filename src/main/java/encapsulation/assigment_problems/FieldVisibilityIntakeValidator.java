package encapsulation.assigment_problems;

public class FieldVisibilityIntakeValidator {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "protected":
                return accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2
                        && classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) {
                    allowed++;
                } else {
                    denied++;
                }
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    static class PatientRecord {
        private final String patientId;
        String wardCode;
        protected double vitalsScore;
        public String facilityName;

        public PatientRecord(String patientId, String wardCode,
                             double vitalsScore, String facilityName) {
            String trimmedId = patientId == null ? "" : patientId.trim();
            if (trimmedId.length() < 4) {
                throw new IllegalArgumentException("Invalid patientId");
            }

            this.patientId = trimmedId;
            this.wardCode = wardCode;
            this.vitalsScore = vitalsScore;
            this.facilityName = facilityName;
        }
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("default", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(new String[][] {
                {"protected", "SAME_PACKAGE"},
                {"protected", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        }));
    }
}
