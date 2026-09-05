package constructors.assigment_problems;
public class CanteenTrustScoreRanking {
    static class Canteen {
        String code,name;
        int score;
        Canteen(String c,String n,int s) {
            code=c;
            name=n;
            score=s;
        }
        Canteen(String c,String n) {
            this(c,n,3);
        }
        int compareTo(Canteen o) {
            int x=Integer.compare(o.score,score);
            if(x!=0)return x;
            x=code.compareToIgnoreCase(o.code);
            if(x!=0)return x;
            return Integer.compare(name.length(),o.name.length());
        }
    }
    static Canteen[] rankCanteens(Canteen[] c) {
        Canteen[] a=c.clone();
        for(int i=0;i<a.length-1;i++)for(int j=0;j<a.length-1-i;j++)if(a[j].compareTo(a[j+1])>0) {
            Canteen t=a[j];
            a[j]=a[j+1];
            a[j+1]=t;
        }
        return a;
    }
    public static void main(String[]a) {
        for(Canteen c:rankCanteens(new Canteen[] {
            new Canteen("HB3-C","Spice Junction",3),new Canteen("hb1-c","Grand Mess",5),new Canteen("HB2-C","Southern Treats")
        }
        ))System.out.println(c.code);
    }
}
