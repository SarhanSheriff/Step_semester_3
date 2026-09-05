package oop.class_problems;
public class InstanceStaticBoundary {
    static class SrmStudent {
        private String name,regNo;
        private int attendance;
        SrmStudent(String n,String r,int a) {
            name=n;
            regNo=r;
            attendance=a;
        }
        String getName() {
            return name;
        }
        String getRegNo() {
            return regNo;
        }
        int getAttendance() {
            return attendance;
        }
    }
    public static void main(String[]a) {
        SrmStudent one=new SrmStudent("Ravi","R1",82),two=new SrmStudent("Anitha","R2",68);
        System.out.println(one.getName()+" "+one.getAttendance());
        System.out.println(two.getName()+" "+two.getAttendance());
    }
}
