package oop.assigment_problems;
public class LibraryFineSystem {
    static class BookIssue {
        String title,borrowerName;
        int daysOverdue;
        BookIssue(String t,String b,int d) {
            title=t;
            borrowerName=b;
            daysOverdue=d;
        }
        double fineAmount() {
            return daysOverdue>0?daysOverdue*5.0:0;
        }
        boolean isSeverelyOverdue() {
            return daysOverdue>14;
        }
        static double totalFineCollected(BookIssue[] a) {
            double s=0;
            for(BookIssue x:a)s+=x.fineAmount();
            return s;
        }
    }
    public static void main(String[]a) {
        BookIssue[] x= {
            new BookIssue("Clean Code","A",18),new BookIssue("Effective Java","B",5),new BookIssue("Refactoring","C",0),new BookIssue("DSA Handbook","D",21),new BookIssue("Design Patterns","E",9)
        }
        ;
        for(BookIssue b:x)System.out.println(b.title+" - "+b.daysOverdue+" days - "+(b.isSeverelyOverdue()?"Severely overdue":"OK"));
        System.out.println("Total fine collected: Rs "+BookIssue.totalFineCollected(x));
    }
}
