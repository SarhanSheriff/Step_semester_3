package oop.assigment_problems;
public class HrParkingMiniSystem {
    static class Employee {
        String id;
        double salary;
        Employee(String i,double s) {
            id=i;
            salary=s;
        }
    }
    static class Manager extends Employee {
        double bonus;
        Manager(String i,double s,double b) {
            super(i,s);
            bonus=b;
        }
        double pay() {
            return salary+bonus;
        }
    }
    static class ParkingSlot {
        String no;
        int cap,used;
        ParkingSlot(String n,int c,int u) {
            no=n;
            cap=c;
            used=u;
        }
        boolean allot() {
            if(used>=cap)return false;
            used++;
            return true;
        }
    }
    static ParkingSlot find(ParkingSlot[] s) {
        for(ParkingSlot p:s)if(p.used<p.cap)return p;
        return null;
    }
    public static void main(String[]a) {
        Employee e=new Manager("M1",70000,8000);
        ParkingSlot p=find(new ParkingSlot[] {
            new ParkingSlot("A1",1,1),new ParkingSlot("A2",2,1)
        }
        );
        System.out.println("Manager pay: "+((Manager)e).pay());
        System.out.println("Parking slot: "+(p==null?"None":p.no));
    }
}
