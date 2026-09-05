package oop.class_problems;
public class FeeHostelMiniSystem {
    static class FeeAccount {
        double total,paid;
        FeeAccount(double total) {
            this.total=total;
        }
        void pay(double x) {
            if(x>0)paid=Math.min(total,paid+x);
        }
        double due() {
            return total-paid;
        }
    }
    static class ScholarshipAccount extends FeeAccount {
        double pct;
        ScholarshipAccount(double t,double p) {
            super(t);
            pct=p;
        }
        double effectiveDue() {
            return due()*(1-pct/100);
        }
    }
    static class HostelRoom {
        String room;
        int beds,used;
        HostelRoom(String r,int b,int u) {
            room=r;
            beds=b;
            used=u;
        }
        boolean allot() {
            if(used>=beds)return false;
            used++;
            return true;
        }
    }
    static HostelRoom firstAvailable(HostelRoom[] rooms) {
        for(HostelRoom r:rooms)if(r.used<r.beds)return r;
        return null;
    }
    public static void main(String[]a) {
        FeeAccount f=new FeeAccount(100000);
        f.pay(30000);
        ScholarshipAccount s=new ScholarshipAccount(120000,25);
        HostelRoom r=firstAvailable(new HostelRoom[] {
            new HostelRoom("A1",2,2),new HostelRoom("A2",3,1)
        }
        );
        System.out.println("Regular due: "+f.due());
        System.out.println("Scholarship due: "+s.effectiveDue());
        System.out.println("Room: "+(r==null?"None":r.room));
    }
}
