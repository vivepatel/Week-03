package doublylinkedlist.librarymanagementsystem;



public class LibraryManagementSystem {
    private Book head;
    private Book tail;

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newBook.next = current.next;
        if (current.next != null) {
            current.next.prev = newBook;
        } else {
            tail = newBook;
        }
        current.next = newBook;
        newBook.prev = current;
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            System.out.println("Book with ID " + bookId + " removed successfully!");
            return;
        }
        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found!");
        } else {
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            System.out.println("Book with ID " + bookId + " removed successfully!");
        }
    }

    // Search for a book by Title
    public void searchByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Found: Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with title " + title + " not found!");
    }

    // Search for a book by Author
    public void searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Found: Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
                return;
            }
            current = current.next;
        }
        System.out.println("Book by author " + author + " not found!");
    }

    // Update a book's availability status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability status updated for Book ID " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found!");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty!");
            return;
        }
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    // Count total number of books
    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addAtEnd("Book A", "Author A", "Fiction", 101, true);
        library.addAtBeginning("Book B", "Author B", "Non-Fiction", 102, false);
        library.addAtPosition(2, "Book C", "Author C", "Science", 103, true);

        System.out.println("All Books (Forward):");
        library.displayForward();

        System.out.println("\nAll Books (Reverse):");
        library.displayReverse();

        System.out.println("\nUpdating Availability of Book ID 102 to true:");
        library.updateAvailability(102, true);
        library.displayForward();

        System.out.println("\nSearching for Book with Title 'Book A':");
        library.searchByTitle("Book A");

        System.out.println("\nSearching for Books by Author 'Author B':");
        library.searchByAuthor("Author B");

        System.out.println("\nTotal Number of Books:");
        System.out.println("Count: " + library.countBooks());

        System.out.println("\nRemoving Book with ID 103:");
        library.removeByBookId(103);
        library.displayForward();
    }
}
