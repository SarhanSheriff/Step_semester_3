package abstraction.assignment_problems.problem_2;

public class OneClickDataExport {
    interface Exportable {
        String exportData();
    }

    private static int totalExports;

    static class ReportGenerator implements Exportable {
        private final String reportName;

        ReportGenerator(String reportName) {
            this.reportName = reportName;
        }

        @Override
        public String exportData() {
            totalExports++;
            return "Exported report: " + reportName;
        }
    }

    static class UserProfile implements Exportable {
        private final String username;

        UserProfile(String username) {
            this.username = username;
        }

        @Override
        public String exportData() {
            totalExports++;
            return "Exported profile: " + username;
        }
    }

    static int getTotalExports() {
        return totalExports;
    }

    static void exportAll(Exportable[] items) {
        for (Exportable item : items) {
            System.out.println(item.exportData());
        }
    }
}
