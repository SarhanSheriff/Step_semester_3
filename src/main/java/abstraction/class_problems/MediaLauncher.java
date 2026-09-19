package abstraction.class_problems;

public class MediaLauncher {
    public static void launchAll(Playable[] items) {
        for (Playable item : items) {
            System.out.println(item.play());
        }
    }
}