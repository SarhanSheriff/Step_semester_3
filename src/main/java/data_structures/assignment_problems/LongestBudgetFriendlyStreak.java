package data_structures.assignment_problems;

public class LongestBudgetFriendlyStreak {
    public static int[] longestStreak(int[] costs, int budget) {
        int left = 0, sum = 0, bestLength = 0, bestStart = -1;

        for (int right = 0; right < costs.length; right++) {
            sum += costs[right];
            while (sum > budget && left <= right) sum -= costs[left++];
            int length = right - left + 1;
            if (length > bestLength) {
                bestLength = length;
                bestStart = left;
            }
        }
        return bestLength == 0 ? new int[]{0, -1}
                : new int[]{bestLength, bestStart};
    }

    public static void main(String[] args) {
        int[] result = longestStreak(new int[]{4, 2, 1, 7, 3, 1, 2, 1, 5}, 8);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}