package data_structures.class_problems;

import java.util.Arrays;

public class PairSumSortedArray {
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{nums[left], nums[right]};
            if (sum < target) left++;
            else right--;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairSumSorted(
                new int[]{-4, -1, 0, 3, 5, 9}, 4)));
    }
}