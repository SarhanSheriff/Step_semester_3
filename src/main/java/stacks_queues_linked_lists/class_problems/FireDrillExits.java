package stacks_queues_linked_lists.class_problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FireDrillExits {
    private static final int[] ROW = {-1, 1, 0, 0};
    private static final int[] COL = {0, 0, -1, 1};

    public static int[][] exitDistance(char[][] plan) {
        int rows = plan.length;
        int cols = plan[0].length;
        int[][] distance = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (plan[r][c] == '#') {
                    distance[r][c] = -1;
                } else if (plan[r][c] == 'E') {
                    queue.offer(new int[]{r, c});
                } else {
                    distance[r][c] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cell[0] + ROW[i];
                int nextCol = cell[1] + COL[i];

                if (nextRow < 0 || nextRow >= rows
                        || nextCol < 0 || nextCol >= cols) {
                    continue;
                }

                if (plan[nextRow][nextCol] == '.'
                        && distance[nextRow][nextCol] == -1) {
                    distance[nextRow][nextCol] =
                            distance[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        char[][] plan = {
            {'.', '.', '#', '.'},
            {'.', '#', '.', '.'},
            {'E', '.', '.', '.'}
        };

        int[][] result = exitDistance(plan);
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

// Time: O(rows * columns), Space: O(rows * columns).
