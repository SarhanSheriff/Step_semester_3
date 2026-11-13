package stacks_queues_linked_lists.assignment_problems;
import java.util.ArrayDeque;
import java.util.Queue;
public class FireDrillExits {
    public static int[][] exitDistance(char[][] plan) {
        int rows = plan.length;
        if (rows == 0) return new int[0][0];
        int cols = plan[0].length;
        int[][] distance = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                distance[r][c] = -1;
                if (plan[r][c] == 'E') {
                    distance[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i], nc = col + dc[i];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                        && plan[nr][nc] != '#' && distance[nr][nc] == -1) {
                    distance[nr][nc] = distance[row][col] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) {
        char[][] plan = {{'.', '#', '.', 'E'}, {'.', '.', '.', '#'}, {'E', '#', '.', '.'}};
        int[][] result = exitDistance(plan);
        for (int[] row : result) {
            for (int value : row) System.out.print(value + " ");
            System.out.println();
        }
    }
}