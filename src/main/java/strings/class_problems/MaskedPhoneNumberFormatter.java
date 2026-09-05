package strings.class_problems;
public class MaskedPhoneNumberFormatter {
    static String maskPhoneNumber(String phone) {
        if(phone==null||phone.length()!=10)return"Invalid phone number";
        for(char c:phone.toCharArray())if(!Character.isDigit(c))return"Invalid phone number";
        StringBuilder b=new StringBuilder("XXXXXX");
        b.insert(6,"-");
        b.append(phone.substring(6));
        return b.toString();
    }
    public static void main(String[]a) {
        System.out.println(maskPhoneNumber("9876543210"));
    }
}
