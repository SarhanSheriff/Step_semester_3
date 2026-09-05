package fundamentals.class_problems;
import java.util.*;
public class FirstNonRepeatingCharacter {
    static char findFirstNonRepeatingChar(String text) {
        Map<Character,Integer> f=new HashMap<>();
        for(char c:text.toCharArray())f.put(c,f.getOrDefault(c,0)+1);
        for(char c:text.toCharArray())if(f.get(c)==1)return c;
        return '\0';
    }
    public static void main(String[] args) {
        char c=findFirstNonRepeatingChar("swiss");
        System.out.println(c=='\0'?"No Non-Repeating Character Found":"First Non-Repeating Character: '"+c+"'");
    }
}
