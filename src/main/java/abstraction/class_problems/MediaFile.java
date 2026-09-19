package abstraction.class_problems;

public abstract class MediaFile {
    private static int nextId = 1001;
    private final String fileId;

    protected MediaFile() {
        fileId = "MF-" + nextId++;
    }

    public abstract String getFormatInfo();

    public String getFileId() {
        return fileId;
    }
}