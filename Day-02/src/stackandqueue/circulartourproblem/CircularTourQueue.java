package stackandqueue.circulartourproblem;

import java.util.LinkedList;
import java.util.Queue;

class CircularTourQueue {
    // Function to find the starting petrol pump index
    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            int netPetrol = petrol[i] - distance[i];
            totalSurplus += netPetrol;
            currentSurplus += netPetrol;
            queue.offer(i); // Add current pump to queue

            // If current surplus goes negative, remove elements from queue
            while (currentSurplus < 0 && !queue.isEmpty()) {
                int removedPump = queue.poll(); // Remove front element
                currentSurplus -= petrol[removedPump] - distance[removedPump];
                startIndex = removedPump + 1; // Move starting index forward
            }
        }

        // If total surplus is negative, no valid start exists
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4}; // Petrol at each station
        int[] distance = {6, 5, 3, 5}; // Distance to next station

        int startPump = findStartingPump(petrol, distance);

        if (startPump != -1) {
            System.out.println("Start the tour at petrol pump: " + startPump);
        } else {
            System.out.println("No solution possible.");
        }
    }
}
