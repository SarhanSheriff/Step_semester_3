package data_structures.class_problems;

public class MaxSumSubarrayFixedK {
    public static int maxSumSubarray(int[] sales, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += sales[i];
        int max = sum;

        for (int i = k; i < sales.length; i++) {
            sum += sales[i] - sales[i - k];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubarray(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }
}