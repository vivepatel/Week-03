package circularlinkedlist.roundrobinschedulingalgorithm;

public class Process {
    int pid;
    int burstTime;
    int priority;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
