package abstraction.class_problems;

public class Podcast implements Playable {
    private final String showName;
    private final int episodeNumber;

    public Podcast(String showName, int episodeNumber) {
        this.showName = showName;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public String play() {
        return "Streaming episode " + episodeNumber + " of " + showName;
    }

    @Override
    public String play(int fromSecond) {
        return "Streaming episode " + episodeNumber + " of " + showName
                + " from " + fromSecond + " seconds";
    }

    @Override
    public String pause() {
        return "Paused episode " + episodeNumber + " of " + showName;
    }
}