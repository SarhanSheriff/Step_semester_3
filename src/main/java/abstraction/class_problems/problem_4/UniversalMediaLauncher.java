package abstraction.class_problems.problem_4;

public class UniversalMediaLauncher {
    interface Playable {
        String play();
        String play(int fromSecond);
        String pause();
    }

    static abstract class MediaFile {
        private static int nextId = 1001;
        private final String fileId = "MF-" + nextId++;

        public abstract String getFormatInfo();

        public String getFileId() {
            return fileId;
        }
    }

    static class AudioFile extends MediaFile implements Playable {
        private final String title;

        AudioFile(String title) {
            this.title = title;
        }

        @Override
        public String play() {
            return "Playing audio: " + title;
        }

        @Override
        public String play(int fromSecond) {
            return "Playing audio: " + title + " from "
                    + (fromSecond / 60) + ":"
                    + String.format("%02d", fromSecond % 60);
        }

        @Override
        public String pause() {
            return "Paused audio: " + title;
        }

        @Override
        public String getFormatInfo() {
            return "Audio file, ID: " + getFileId();
        }
    }

    static class Podcast implements Playable {
        private final String showName;
        private final int episodeNumber;

        Podcast(String showName, int episodeNumber) {
            this.showName = showName;
            this.episodeNumber = episodeNumber;
        }

        @Override
        public String play() {
            return "Streaming episode " + episodeNumber + " of " + showName;
        }

        @Override
        public String play(int fromSecond) {
            return "Streaming episode " + episodeNumber + " of "
                    + showName + " from " + fromSecond + " seconds";
        }

        @Override
        public String pause() {
            return "Paused episode " + episodeNumber + " of " + showName;
        }
    }

    public static void launchAll(Playable[] items) {
        for (Playable item : items) {
            System.out.println(item.play());
        }
    }
}
