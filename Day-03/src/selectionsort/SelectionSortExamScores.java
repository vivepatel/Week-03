package selectionsort;

import java.util.Arrays;

public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            swap(scores, i, minIndex);
        }
    }

    public static void swap(int[] scores, int i, int j) {
        int temp = scores[i];
        scores[i] = scores[j];
        scores[j] = temp;
    }

    public static void main(String[] args) {
        int[] examScores = {85, 72, 90, 68, 88};

        System.out.println("Unsorted Exam Scores: " + Arrays.toString(examScores));

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));
    }
}
