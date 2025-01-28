package circularlinkedlist.tasksheduler;

public class TaskScheduler {
    private Task head;

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task current = head;
        for (int i = 1; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }
        if (current.next == head && position != 2) {
            System.out.println("Position out of bounds!");
            return;
        }
        newTask.next = current.next;
        current.next = newTask;
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        Task current = head;
        Task previous = null;
        do {
            if (current.taskId == taskId) {
                if (previous != null) {
                    previous.next = current.next;
                } else {
                    Task temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                }
                System.out.println("Task with ID " + taskId + " removed successfully!");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskId + " not found!");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNext() {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        System.out.println("Current Task: ID: " + head.taskId + ", Name: " + head.taskName + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
        head = head.next;
    }

    // Display all tasks starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks found!");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No task found with Priority " + priority);
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Task A", 1, "2025-02-01");
        scheduler.addAtBeginning(2, "Task B", 2, "2025-01-30");
        scheduler.addAtPosition(2, 3, "Task C", 1, "2025-02-05");

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nViewing and moving to the next task:");
        scheduler.viewAndMoveToNext();

        System.out.println("\nAll Tasks After Viewing:");
        scheduler.displayTasks();

        System.out.println("\nSearching for tasks with Priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task with ID 3:");
        scheduler.removeByTaskId(3);

        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayTasks();
    }
}
