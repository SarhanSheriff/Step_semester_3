package fundamentals.assigment_problems;
public class MovieReviewWordLengthProfiler {
    static void classifyWordLengths(String review) {
        int s=0,m=0,l=0;
        for(String w:review.trim().split("\\s+")) {
            String x=w.replaceAll("[^A-Za-z]","");
            int n=x.length();
            if(n>=1&&n<=4)s++;
            else if(n<=8)m++;
            else l++;
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d%n",s,m,l);
    }
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
