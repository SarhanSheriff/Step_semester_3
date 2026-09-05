package strings.class_problems;
public class CsvStudentRecordParser {
    static void parseStudentRecord(String line) {
        String[] p=line.split(",");
        if(p.length!=3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: "+p[0]+" | Roll No: "+p[1]+" | Dept: "+p[2]);
    }
    public static void main(String[]a) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}
