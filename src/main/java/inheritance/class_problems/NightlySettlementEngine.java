package inheritance.class_problems;

public final class NightlySettlementEngine {
    private NightlySettlementEngine() {
    }

    public static String processNightlySettlement(EventTicket[] tickets) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;

        for (EventTicket ticket : tickets) {
            if (ticket == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            if (ticket instanceof GroupTicket)
                group++;
            else
                individual++;
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }
}
