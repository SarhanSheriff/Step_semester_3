package data_structures.class_problems;

public class LibraryCatalogLookup {
    public static String findBook(String[][] catalog, String targetIsbn) {
        int left = 0, right = catalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = catalog[mid][0].compareTo(targetIsbn);
            if (compare == 0) return catalog[mid][1];
            if (compare < 0) left = mid + 1;
            else right = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] books = {{"0001112223", "Intro to Algebra"},
                {"0002223334", "Beginning Python"},
                {"0003334445", "Classic Mythology"}};
        System.out.println(findBook(books, "0003334445"));
    }
}