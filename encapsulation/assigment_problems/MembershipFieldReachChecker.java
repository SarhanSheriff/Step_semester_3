public class MembershipFieldReachChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")
                        ? "ALLOWED" : "DENIED";
            case "protected":
                return accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE")
                        || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                        ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {
        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;

        for (String[] attempt : attempts) {
            String modifier = attempt[0];
            String result = classifyAccess(modifier, attempt[1]);

            if (modifier.equals("private")) {
                if (result.equals("ALLOWED")) privateAllowed++; else privateDenied++;
            } else if (modifier.equals("default")) {
                if (result.equals("ALLOWED")) defaultAllowed++; else defaultDenied++;
            } else if (modifier.equals("protected")) {
                if (result.equals("ALLOWED")) protectedAllowed++; else protectedDenied++;
            } else if (modifier.equals("public")) {
                if (result.equals("ALLOWED")) publicAllowed++; else publicDenied++;
            }
        }

        return "private: " + privateAllowed + " allowed / " + privateDenied + " denied"
                + " | default: " + defaultAllowed + " allowed / " + defaultDenied + " denied"
                + " | protected: " + protectedAllowed + " allowed / " + protectedDenied + " denied"
                + " | public: " + publicAllowed + " allowed / " + publicDenied + " denied";
    }

    static class LibraryMember {
        private final String membershipId;
        String branchCode;
        double finesOwed;
        protected String displayName;

        public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
            String trimmed = membershipId == null ? "" : membershipId.trim();
            if (trimmed.isEmpty() || trimmed.length() < 4) {
                throw new IllegalArgumentException("Invalid membershipId");
            }
            this.membershipId = trimmed;
            this.branchCode = branchCode;
            this.finesOwed = finesOwed;
            this.displayName = displayName;
        }
    }
}
