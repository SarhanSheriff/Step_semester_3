package data_structures.class_problems;

public class ProductPriceFinder {
    private static int bound(int[] prices, int target, boolean upper) {
        int left = 0, right = prices.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prices[mid] < target || (upper && prices[mid] == target))
                left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int countInRange(int[] prices, int low, int high) {
        int start = bound(prices, low, false);
        int end = bound(prices, high, true);
        System.out.println("Lower bound index " + start);
        System.out.println("Upper bound index " + end);
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println("Count " + countInRange(
                new int[]{100, 150, 150, 200, 300, 450}, 150, 300));
    }
}