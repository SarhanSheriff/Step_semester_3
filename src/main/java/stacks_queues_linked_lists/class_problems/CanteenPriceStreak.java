package stacks_queues_linked_lists.class_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class CanteenPriceStreak {
    public static int[] priceStreak(int[] price) {
        int[] streak = new int[price.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            streak[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return streak;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = priceStreak(prices);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

// Time: O(n), Space: O(n).
