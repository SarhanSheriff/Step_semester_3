package strings.class_problems;
public class FileExtensionValidator {
    static String validateFileExtension(String filename) {
        int i=filename.lastIndexOf('.');
        if(i<0)return"Rejected — invalid file type";
        String e=filename.substring(i+1);
        return e.equalsIgnoreCase("pdf")||e.equalsIgnoreCase("docx")||e.equalsIgnoreCase("zip")?"Accepted":"Rejected — invalid file type";
    }
    public static void main(String[]a) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
    }
}
