package data_structures.assignment_problems;

import java.util.Arrays;

public class MallFootfallRangeReport {
    public static int[] footfallReport(int[] visitors, int[][] queries) {
        int[] prefix = new int[visitors.length + 1];
        for (int i = 0; i < visitors.length; i++)
            prefix[i + 1] = prefix[i] + visitors[i];

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            result[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        return result;
    }

    public static void main(String[] args) {
        int[] visitors = {12, 7, 3, 9, 15, 4, 8};
        int[][] queries = {{0, 2}, {2, 5}, {4, 6}, {3, 3}};
        System.out.println(Arrays.toString(footfallReport(visitors, queries)));
    }
}