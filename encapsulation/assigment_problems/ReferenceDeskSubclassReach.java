public class ReferenceDeskSubclassReach {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }
        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("default")) {
            return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            return accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")
                    || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                    ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    static String describeContext(String accessorContext) {
        String[] parts = accessorContext.split("_");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(part.substring(0, 1).toUpperCase())
                    .append(part.substring(1).toLowerCase());
        }

        return result.toString();
    }
}
