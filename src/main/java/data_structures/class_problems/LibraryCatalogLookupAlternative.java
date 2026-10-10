package data_structures.class_problems;

public class LibraryCatalogLookupAlternative {
    public static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (catalog[mid][0].equals(targetIsbn)) return catalog[mid][1];
            if (catalog[mid][0].compareTo(targetIsbn) < 0) low = mid + 1;
            else high = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {{"0001112223", "Intro to Algebra"},
                {"0002223334", "Beginning Python"},
                {"0003334445", "Classic Mythology"}};
        System.out.println(findBook(catalog, "0009998887"));
    }
}