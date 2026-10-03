package abstraction.class_problems.problem_3;

public class QuarterlyBonusCalculator {
    static abstract class StaffMember {
        private double baseSalary;
        protected double bonusRate;

        StaffMember(double baseSalary) {
            this(baseSalary, 0.10);
        }

        StaffMember(double baseSalary, double bonusRate) {
            this.baseSalary = baseSalary;
            this.bonusRate = bonusRate;
        }

        public abstract double calculateBonus();

        public double getSalary() {
            return baseSalary;
        }

        public void setSalary(double baseSalary) {
            if (baseSalary >= 0) {
                this.baseSalary = baseSalary;
            }
        }
    }

    interface Auditable {
        String auditRecord();
    }

    static class TeamLead extends StaffMember implements Auditable {
        private final int teamSize;

        TeamLead(double baseSalary, int teamSize) {
            super(baseSalary);
            this.teamSize = teamSize;
        }

        TeamLead(double baseSalary, double bonusRate, int teamSize) {
            super(baseSalary, bonusRate);
            this.teamSize = teamSize;
        }

        @Override
        public double calculateBonus() {
            return getSalary() * bonusRate;
        }

        @Override
        public String auditRecord() {
            return "TeamLead audit: " + teamSize
                    + " team members, salary $" + getSalary();
        }
    }

    public static String getAuditIfApplicable(StaffMember staff) {
        if (staff instanceof Auditable) {
            return ((Auditable) staff).auditRecord();
        }
        return "No audit required";
    }
}
