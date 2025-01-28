package circularlinkedlist.roundrobinschedulingalgorithm;



public class RoundRobin {
    Process head;
    int timeQuantum;
    int totalProcesses;
    int completedProcesses;
    int totalWaitingTime;
    int totalTurnaroundTime;

    RoundRobin(int timeQuantum) {
        this.head = null;
        this.timeQuantum = timeQuantum;
        this.totalProcesses = 0;
        this.completedProcesses = 0;
        this.totalWaitingTime = 0;
        this.totalTurnaroundTime = 0;
    }

    void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head; // Make it circular
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        totalProcesses++;
    }

    void removeProcess(int pid) {
        if (head == null) return;

        Process current = head;
        Process previous = null;

        do {
            if (current.pid == pid) {
                if (previous == null) { // Removing the head
                    if (current.next == head) { // Only one element
                        head = null;
                    } else {
                        Process last = head;
                        while(last.next != head) {
                            last = last.next;
                        }
                        last.next = current.next;
                        head = current.next;
                    }
                } else {
                    previous.next = current.next;
                }
                completedProcesses++;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }


    void simulate() {
        if (head == null) return;

        Process current = head;
        int currentTime = 0;

        while (completedProcesses < totalProcesses) {
            System.out.print("Current Queue: ");
            displayQueue();
            System.out.println();

            int executionTime = Math.min(timeQuantum, current.burstTime);
            current.burstTime -= executionTime;
            currentTime += executionTime;

            if (current.burstTime == 0) {
                totalTurnaroundTime += currentTime;
                totalWaitingTime += (currentTime - (totalTurnaroundTime - current.burstTime)); // Corrected waiting time calculation
                removeProcess(current.pid);

            } else {
                totalWaitingTime += (currentTime - (totalTurnaroundTime - current.burstTime)); // Corrected waiting time calculation
            }

            current = current.next == null ? head : current.next; // Move to the next process or head if the next is null.

        }

        double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;

        System.out.println("\nSimulation Complete:");
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    void displayQueue() {
        if (head == null) {
            System.out.print("Empty");
            return;
        }

        Process temp = head;
        do {
            System.out.print("P" + temp.pid + "(" + temp.burstTime + ") -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.print("Head");
    }


    public static void main(String[] args) {
        RoundRobin scheduler = new RoundRobin(2); // Time quantum = 2

        scheduler.addProcess(1, 5, 1);
        scheduler.addProcess(2, 3, 2);
        scheduler.addProcess(3, 7, 3);

        scheduler.simulate();
    }
}