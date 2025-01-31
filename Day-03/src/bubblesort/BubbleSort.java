package bubblesort;

public class BubbleSort {
    public static void bubbleSort(int[] studentMarks) {
        int n = studentMarks.length;
        boolean swapped;

        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already sorted, so no need to check them
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next element
                if (studentMarks[j] > studentMarks[j + 1]) {
                    // Swap elements
                    int temp = studentMarks[j];
                    studentMarks[j] = studentMarks[j + 1];
                    studentMarks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swapping happened, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(studentMarks);

        // Sort the array using Bubble Sort
        bubbleSort(studentMarks);

        System.out.println("Sorted array:");
        printArray(studentMarks);
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}