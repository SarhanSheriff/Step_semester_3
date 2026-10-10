package data_structures.assignment_problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralStockAuditRoute {
    public static List<Integer> auditRoute(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) result.add(grid[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) result.add(grid[r][right]);
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) result.add(grid[bottom][c]);
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) result.add(grid[r][left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(auditRoute(grid));
    }
}