package data_structures.class_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class LibraryResource {
    String id;
    boolean reservable;
    boolean downloadable;

    LibraryResource(String id, boolean reservable, boolean downloadable) {
        this.id = id;
        this.reservable = reservable;
        this.downloadable = downloadable;
    }
}

public class LibraryPlatform {
    private final List<LibraryResource> resources = new ArrayList<>();

    public void add(LibraryResource item) {
        for (LibraryResource resource : resources) {
            if (resource.id.equals(item.id)) {
                System.out.println("duplicate rejected");
                return;
            }
        }
        resources.add(item);
        resources.sort(Comparator.comparing(resource -> resource.id));
        System.out.println(item.id + " added");
    }

    public void reserve(String id, String member) {
        LibraryResource item = find(id);
        if (item == null) System.out.println("Not found");
        else if (!item.reservable) System.out.println(id + " rejected: reserve unsupported");
        else System.out.println(id + " reserved for " + member);
    }

    public void download(String id) {
        LibraryResource item = find(id);
        if (item == null) System.out.println("Not found");
        else if (!item.downloadable) System.out.println(id + " rejected: download unsupported");
        else System.out.println(id + " downloaded");
    }

    private LibraryResource find(String id) {
        for (LibraryResource item : resources) if (item.id.equals(id)) return item;
        return null;
    }

    public void showIndex(String id) {
        for (int i = 0; i < resources.size(); i++)
            if (resources.get(i).id.equals(id)) {
                System.out.println(id + " found at index " + i);
                return;
            }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        LibraryPlatform library = new LibraryPlatform();
        library.add(new LibraryResource("B1", true, false));
        library.add(new LibraryResource("B1", true, false));
        library.add(new LibraryResource("E1", false, true));
        library.reserve("B1", "M1");
        library.download("B1");
        library.download("E1");
        library.showIndex("E1");
    }
}