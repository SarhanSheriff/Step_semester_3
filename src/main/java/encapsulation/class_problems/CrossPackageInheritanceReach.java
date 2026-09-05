package encapsulation.class_problems;

public class CrossPackageInheritanceReach {

    static String classifyAccess(String m, String c) {
        if (m.equals("public")) {
            return "ALLOWED";
        }
        if (m.equals("private")) {
            return "SAME_CLASS".equals(c) ? "ALLOWED" : "DENIED";
        }
        if (m.equals("default")) {
            return c.equals("SAME_CLASS") || c.equals("SAME_PACKAGE")
                    ? "ALLOWED"
                    : "DENIED";
        }
        if (m.equals("protected")) {
            return c.equals("SAME_CLASS")
                    || c.equals("SAME_PACKAGE")
                    || c.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                    ? "ALLOWED"
                    : "DENIED";
        }
        return "DENIED";
    }

    static String describeContext(String c) {
        StringBuilder b = new StringBuilder();

        for (String w : c.split("_")) {
            if (b.length() > 0) {
                b.append(' ');
            }
            b.append(w.charAt(0));
            b.append(w.substring(1).toLowerCase());
        }

        return b.toString();
    }

    public static void main(String[] a) {
        System.out.println(
                classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(
                classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(
                describeContext("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
