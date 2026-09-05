package oop.assigment_problems;
public class EmployeeExtension {
    static class Employee {
        private String empId,empName;
        private double salary;
        Employee(String i,String n,double s) {
            empId=i;
            empName=n;
            salary=s;
        }
        double getSalary() {
            return salary;
        }
    }
    static class ManagerEmployee extends Employee {
        double teamBonus;
        ManagerEmployee(String i,String n,double s,double b) {
            super(i,n,s);
            teamBonus=b;
        }
        double effectiveSalary() {
            return getSalary()+teamBonus;
        }
    }
    static class InternEmployee extends Employee {
        double stipendCap;
        InternEmployee(String i,String n,double s,double c) {
            super(i,n,s);
            stipendCap=c;
        }
        double effectiveSalary() {
            return Math.min(getSalary(),stipendCap);
        }
    }
    public static void main(String[]a) {
        Employee[] e= {
            new Employee("E1","A",40000),new ManagerEmployee("E2","B",70000,8000),new InternEmployee("E3","C",12000,10000)
        }
        ;
        for(Employee x:e)if(x instanceof ManagerEmployee)System.out.println("Manager effective pay: Rs "+((ManagerEmployee)x).effectiveSalary());
        else if(x instanceof InternEmployee)System.out.println("Intern effective pay: Rs "+((InternEmployee)x).effectiveSalary());
        else System.out.println("Plain employee pay: Rs "+x.getSalary());
    }
}
