package abstraction.class_problems;

public class BonusCalculator {
    public static String getAuditIfApplicable(StaffMember s) {
        if (s instanceof Auditable) {
            return ((Auditable) s).auditRecord();
        }
        return "No audit required";
    }
}