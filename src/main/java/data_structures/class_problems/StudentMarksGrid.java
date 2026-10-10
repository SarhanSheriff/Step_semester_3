package data_structures.class_problems;

public class StudentMarksGrid {
    public static void main(String[] args) {
        String[] names = {"Anu", "Ravi", "Meena"};
        String[] subjects = {"Math", "Science", "English"};
        int[][] marks = {{80, 90, 70}, {60, 85, -1}, {95, 75, 88}};
        int[] toppers = {-1, -1, -1};
        String[] topperNames = new String[subjects.length];

        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            for (int j = 0; j < subjects.length; j++) {
                if (marks[i][j] >= 0) {
                    total += marks[i][j];
                    if (marks[i][j] > toppers[j]) {
                        toppers[j] = marks[i][j];
                        topperNames[j] = names[i];
                    }
                }
            }
            System.out.println("Total " + names[i] + " " + total);
        }
        for (int j = 0; j < subjects.length; j++)
            System.out.println(subjects[j] + " topper: " + topperNames[j] + " " + toppers[j]);
    }
}