package advanced_oop_and_algorithms.class_problems;
import java.util.Scanner;
public class PlacementDriveShortlist {
    static class Candidate {
        String name;
        int[] scores;
        int total;
        int bestGain;
        int startTest;
        int endTest;
        Candidate(String name, int[] scores) {
            this.name = name;
            this.scores = scores;
            for (int score : scores) total += score;
            findBestClimb();
        }
        private void findBestClimb() {
            int current = scores[1] - scores[0];
            int currentStart = 1;
            bestGain = current;
            startTest = 1;
            endTest = 2;
            for (int i = 2; i < scores.length; i++) {
                int change = scores[i] - scores[i - 1];
                if (current + change < change) {
                    current = change;
                    currentStart = i;
                } else current += change;
                if (current > bestGain) {
                    bestGain = current;
                    startTest = currentStart;
                    endTest = i + 1;
                }
            }
        }
    }
    private static void mergeSort(Candidate[] a, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        Candidate[] temp = new Candidate[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (a[i].total >= a[j].total) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];
        for (int x = 0; x < temp.length; x++) a[left + x] = temp[x];
    }
    private static int countAtLeast(Candidate[] a, int cutoff) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid].total >= cutoff) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private static String findPair(Candidate[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int sum = a[left].total + a[right].total;
            if (sum == target) return a[left].name + " + " + a[right].name;
            if (sum > target) left++;
            else right--;
        }
        return "no pair";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Candidate[] a = new Candidate[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] scores = new int[6];
            for (int j = 0; j < 6; j++) scores[j] = sc.nextInt();
            a[i] = new Candidate(name, scores);
        }
        mergeSort(a, 0, a.length - 1);
        System.out.println("Shortlist:");
        for (int i = 0; i < n; i++) {
            Candidate c = a[i];
            System.out.println((i + 1) + ". " + c.name + " " + c.total
                    + " | best climb +" + c.bestGain + " (test "
                    + c.startTest + " to " + c.endTest + ")");
        }
        while (sc.hasNext()) {
            String command = sc.next();
            int value = sc.nextInt();
            if (command.equalsIgnoreCase("CUTOFF"))
                System.out.println("CUTOFF " + value + ": " + countAtLeast(a, value) + " candidates");
            else if (command.equalsIgnoreCase("PAIR"))
                System.out.println("PAIR " + value + ": " + findPair(a, value));
        }
        // Merge sort O(n log n), cutoff O(log n), pair search O(n).
        // Taking the left item on equal totals keeps merge sort stable.
    }
}