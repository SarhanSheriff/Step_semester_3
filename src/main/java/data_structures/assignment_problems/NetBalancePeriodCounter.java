package data_structures.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class NetBalancePeriodCounter {
    public static int countPeriods(int[] transactions, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int sum = 0, total = 0;

        for (int value : transactions) {
            sum += value;
            total += counts.getOrDefault(sum - k, 0);
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(countPeriods(new int[]{3, 4, -7, 1, 3, 3, 1, -4}, 7));
    }
}