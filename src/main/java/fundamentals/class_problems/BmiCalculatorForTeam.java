package fundamentals.class_problems;
public class BmiCalculatorForTeam {
    static String getBmiStatus(double bmi) {
        if(bmi<18.5)return"Underweight";
        if(bmi<25)return"Normal";
        if(bmi<30)return"Overweight";
        return"Obese";
    }
    static void printWellnessReport(double[] heights,double[] weights) {
        System.out.println("Person | Height | Weight | BMI | Status");
        for(int i=0;i<heights.length;i++) {
            double bmi=weights[i]/(heights[i]*heights[i]);
            System.out.printf("%d | %.2f | %.1f | %.2f | %s%n",i+1,heights[i],weights[i],bmi,getBmiStatus(bmi));
        }
    }
    public static void main(String[] args) {
        printWellnessReport(new double[] {
            1.75,1.60
        }
        ,new double[] {
            70,90
        }
        );
    }
}
