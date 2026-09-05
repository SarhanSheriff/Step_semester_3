package strings.assigment_problems;
import java.util.*;
public class StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        Set<String> stop=new HashSet<>(Arrays.asList("the","was","and","a","is","of","in"));
        String cleaned=feedback.toLowerCase().replace(".","").replace(",","");
        Map<String,Integer> f=new HashMap<>();
        for(String w:cleaned.split("\\s+"))if(!stop.contains(w))f.put(w,f.getOrDefault(w,0)+1);
        List<Map.Entry<String,Integer>> e=new ArrayList<>(f.entrySet());
        e.sort((x,y)->Integer.compare(y.getValue(),x.getValue()));
        for(Map.Entry<String,Integer> x:e)System.out.println(x.getKey()+": "+x.getValue());
    }
    public static void main(String[]a) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
