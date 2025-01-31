package countingsort;
import java.util.Arrays;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted values back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {15, 12, 18, 10, 14, 16, 12, 17};

        System.out.println("Unsorted Student Ages: " + Arrays.toString(studentAges));

        countingSort(studentAges, 10, 18);

        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}
