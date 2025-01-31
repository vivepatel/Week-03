package heapsort;

import java.util.Arrays;

public class HeapSortJobApplicants {
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    public static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    public static void swap(double[] salaries, int i, int j) {
        double temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }

    public static void main(String[] args) {
        double[] salaryDemands = {50000, 70000, 60000, 90000, 80000};

        System.out.println("Unsorted Salary Demands: " + Arrays.toString(salaryDemands));

        heapSort(salaryDemands);

        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}
