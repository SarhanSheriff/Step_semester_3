package fundamentals.assigment_problems;
public class WarehouseInventoryBalancer {
    static void analyzeInventory(int[] a,int[] b){int sa=0,sb=0,max=Integer.MIN_VALUE,section=0,index=0;for(int i=0;i<a.length;i++){sa+=a[i];if(a[i]>max){max=a[i];section=1;index=i;}}for(int i=0;i<b.length;i++){sb+=b[i];if(b[i]>max){max=b[i];section=2;index=i;}}System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (Section %s, Item %d)%n",sa,sb,sa==sb?"Balanced":"Not Balanced",max,section==1?"A":"B",index+1);}
    public static void main(String[] args){analyzeInventory(new int[]{20,15,30},new int[]{25,10,30});}
}