package constructors.assigment_problems;
public class FoodOrderValidator {
    static class FoodOrder {
        String studentName,dishName;
        boolean delivered;
        FoodOrder(String s,String d) {
            if(s==null||d==null||s.trim().isEmpty()||d.trim().isEmpty())throw new IllegalArgumentException("Invalid order");
            studentName=s.trim();
            dishName=d.trim();
        }
        void markDelivered() {
            if(delivered)System.out.println("Already delivered");
            else {
                delivered=true;
                System.out.println("Delivered");
            }
        }
    }
    static void processBatch(String[][] raw) {
        int v=0,r=0;
        for(String[] x:raw)try {
            new FoodOrder(x[0],x[1]);
            v++;
} catch(Exception e) {
            r++;
        }
        System.out.println("Valid: "+v+" | Rejected: "+r);
    }
    public static void main(String[]a) {
        processBatch(new String[][] {
            {
                "Ravi","Paneer Butter Masala"
            }
            , {
                "","Chole Bhature"
            }
            , {
                "Meera"," "
            }
            , {
                "Divya","Veg Biryani"
            }
        }
        );
    }
}
