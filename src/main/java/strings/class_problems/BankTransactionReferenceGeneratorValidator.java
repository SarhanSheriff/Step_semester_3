package strings.class_problems;
public class BankTransactionReferenceGeneratorValidator {
    static String normalizeReference(String raw) {
        String s=raw.trim();
        if(s.length()<3)return s.toUpperCase();
        return s.substring(0,3).toUpperCase()+s.substring(3);
    }
    static String validateAndFormat(String ref) {
        if(ref.length()!=14)return"Invalid: wrong length";
        for(int i=0;i<3;i++)if(!Character.isLetter(ref.charAt(i)))return"Invalid: bank code must be 3 letters";
        for(int i=3;i<14;i++)if(!Character.isDigit(ref.charAt(i)))return"Invalid: body must be digits";
        StringBuilder b=new StringBuilder();
        b.append("[").append(ref,0,3).append("] DATE: ").append(ref,3,5).append("/").append(ref,5,7).append("/").append(ref,7,9).append(" | SEQ: ").append(ref,9,14);
        return b.toString();
    }
    public static void main(String[]a) {
        String r=normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(r));
    }
}
