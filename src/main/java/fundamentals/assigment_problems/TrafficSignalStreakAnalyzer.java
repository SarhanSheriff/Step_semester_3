package fundamentals.assigment_problems;
public class TrafficSignalStreakAnalyzer {
    static void findLongestStreak(String log) {
        if(log==null||log.isEmpty()) {
            System.out.println("No Signal Data");
            return;
        }
        char best=log.charAt(0),cur=best;
        int bestLen=1,curLen=1;
        for(int i=1;i<log.length();i++) {
            if(log.charAt(i)==cur)curLen++;
            else {
                cur=log.charAt(i);
                curLen=1;
            }
            if(curLen>bestLen) {
                bestLen=curLen;
                best=cur;
            }
        }
        System.out.println("Longest Streak: '"+best+"' repeated "+bestLen+" times");
    }
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
