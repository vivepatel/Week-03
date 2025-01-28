package singlylinkedlist.studentrecordmangement;

public class StudentList {
    private Student head;

    // Add a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    // Add a new student record at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found!");
            return;
        }
        current.next = current.next.next;
    }

    // Search for a student record by Roll Number
    public void searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found!");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No records found!");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully for Roll Number " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found!");
    }

    public static void main(String[] args) {
        StudentList records = new StudentList();

        records.addAtBeginning(1, "Alice", 20, "A");
        records.addAtEnd(2, "Bob", 21, "B");
        records.addAtPosition(2, 3, "Charlie", 22, "C");

        System.out.println("All Student Records:");
        records.displayAll();

        System.out.println("\nSearching for Roll Number 2:");
        records.searchByRollNumber(2);

        System.out.println("\nUpdating Grade for Roll Number 3:");
        records.updateGrade(3, "A+");

        System.out.println("\nAll Student Records After Update:");
        records.displayAll();

        System.out.println("\nDeleting Roll Number 1:");
        records.deleteByRollNumber(1);

        System.out.println("\nAll Student Records After Deletion:");
        records.displayAll();
    }
}

