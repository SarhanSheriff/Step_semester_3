package fundamentals.assigment_problems;
public class TypingSpeedTestAccuracyChecker {
    static void checkTypingAccuracy(String original,String typed){int matches=0,first=-1;for(int i=0;i<original.length();i++){if(original.charAt(i)==typed.charAt(i))matches++;else if(first==-1)first=i;}double accuracy=matches*100.0/original.length();System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ",matches,original.length(),accuracy);if(first==-1)System.out.println("No Mismatches");else System.out.printf("First Mismatch at position %d ('%c' vs '%c')%n",first+1,original.charAt(first),typed.charAt(first));}
    public static void main(String[] args){checkTypingAccuracy("hello world","hello worlt");}
}