package constructors.assigment_problems;
public class NightlyMultiKitchenReconciliationEngine {
    static class DeliveryAccount {
        static {
            System.out.println("Kitchen reconciliation initialized");
        }
        String studentId;
        double orderValue;
        DeliveryAccount(String id,double v) {
            if(v<0)throw new IllegalArgumentException();
            studentId=id;
            orderValue=v;
        }
        DeliveryAccount(String id) {
            this(id,0);
        }
        final double calculateSurgeFee(int delay) {
            return delay<=0?0:orderValue*Math.max(.005*Math.min(delay,5)+.01*Math.max(0,Math.min(delay,15)-5)+.02*Math.max(0,delay-15),.01);
        }
        void processAccount(DeliveryAccount a,double amount,int delay) {
            System.out.println(a.studentId+" surge="+a.calculateSurgeFee(delay));
        }
    }
    static class Premium extends DeliveryAccount {
        Premium(String id,double v) {
            super(id,v);
        }
    }
    static void processBatch(DeliveryAccount[] a,double[] amount,int[] delay) {
        int n=Math.min(a.length,Math.min(amount.length,delay.length)),processed=0,nulls=0,premium=0,regular=0;
        double total=0;
        for(int i=0;i<n;i++) {
            if(a[i]==null) {
                nulls++;
                continue;
            }
            processed++;
            double fee=a[i].calculateSurgeFee(delay[i])*(a[i] instanceof Premium?0.5:1);
            total+=fee;
            if(a[i] instanceof Premium)premium++;
            else regular++;
        }
        System.out.printf("%d processed | %d null skipped | %d premium | %d regular | grand total surge fees = %.2f%n",processed,nulls,premium,regular,total);
    }
    public static void main(String[]a) {
        processBatch(new DeliveryAccount[] {
            new Premium("STU001",500),null,new DeliveryAccount("STU002",300)
        }
        ,new double[] {
            500,400,300
        }
        ,new int[] {
            10,5,0
        }
        );
    }
}
