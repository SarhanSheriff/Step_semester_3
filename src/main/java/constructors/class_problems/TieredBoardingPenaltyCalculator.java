package constructors.class_problems;
public class TieredBoardingPenaltyCalculator {
    static final class BoardingPenalty {
        private final double minimumPenaltyPercent;
        BoardingPenalty(double p) {
            if(p<0)throw new IllegalArgumentException();
            minimumPenaltyPercent=p;
        }
        final double calculatePenalty(double fare,int minutesLate) {
            if(fare<0||minutesLate<0)throw new IllegalArgumentException();
            double m1=Math.min(minutesLate,5),m2=Math.max(0,Math.min(minutesLate,15)-5),m3=Math.max(0,minutesLate-15);
            double tier=fare*(m1*.005+m2*.01+m3*.02);
            double floor=minutesLate==0?0:fare*minimumPenaltyPercent/100;
            return Math.max(tier,floor);
        }
    }
    public static void main(String[]a) {
        BoardingPenalty p=new BoardingPenalty(.5);
        System.out.println(p.calculatePenalty(500,16));
    }
}
