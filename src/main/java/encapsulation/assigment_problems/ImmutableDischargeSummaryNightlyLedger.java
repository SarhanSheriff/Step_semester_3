package encapsulation.assigment_problems;

import java.util.Arrays;

public class ImmutableDischargeSummaryNightlyLedger {
    public static void main(String[] args) {
        DischargeSummary[] summaries = {
                new CriticalCareDischargeSummary("MT001", new String[] {"MED-X"}, 4),
                null,
                new DischargeSummary("MT002", new String[] {"MED-Y"})
        };

        System.out.println(DischargeSummary.processNightlyBatch(summaries));
    }
}

final class DischargeSummary {
    private static final String MEDICATION_PATTERN = "MED-[A-Z]";

    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        if (patientId == null || medicationCodes == null) {
            throw new IllegalArgumentException("Invalid discharge summary");
        }

        String[] copy = medicationCodes.clone();
        for (String code : copy) {
            if (code == null || !code.matches(MEDICATION_PATTERN)) {
                throw new IllegalArgumentException("Invalid medication code");
            }
        }

        this.patientId = patientId;
        this.medicationCodes = copy;
    }

    public String getPatientId() {
        return patientId;
    }

    public String[] getMedicationCodes() {
        return medicationCodes.clone();
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        if (index < 0 || index >= medicationCodes.length
                || newCode == null || !newCode.matches(MEDICATION_PATTERN)) {
            throw new IllegalArgumentException("Invalid correction");
        }

        String[] corrected = medicationCodes.clone();
        corrected[index] = newCode;
        return new DischargeSummary(patientId, corrected);
    }

    static String processNightlyBatch(DischargeSummary[] summaries) {
        int processed = 0;
        int nullSkipped = 0;
        int criticalCare = 0;
        int routine = 0;

        if (summaries != null) {
            for (DischargeSummary summary : summaries) {
                if (summary == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (summary instanceof CriticalCareDischargeSummary) {
                    criticalCare++;
                } else {
                    routine++;
                }
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + criticalCare + " critical-care | "
                + routine + " routine";
    }
}

final class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;

    public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
        super(patientId, medicationCodes);
        if (icuDays < 0) {
            throw new IllegalArgumentException("Invalid ICU days");
        }
        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return icuDays;
    }

    @Override
    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        if (index < 0 || index >= getMedicationCodes().length
                || newCode == null || !newCode.matches("MED-[A-Z]")) {
            throw new IllegalArgumentException("Invalid correction");
        }

        String[] corrected = getMedicationCodes();
        corrected[index] = newCode;
        return new CriticalCareDischargeSummary(getPatientId(), corrected, icuDays);
    }
}
