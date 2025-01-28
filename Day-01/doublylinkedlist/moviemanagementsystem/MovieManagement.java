package doublylinkedlist.moviemanagementsystem;

public class MovieManagement {
    private Movie head;
    private Movie tail;

    // Add a movie record at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie record at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie record at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newMovie.next = current.next;
        newMovie.prev = current;
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        current.next = newMovie;
    }

    // Remove a movie record by Movie Title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Movie with title '" + title + "' removed successfully!");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title '" + title + "' not found!");
    }

    // Search for a movie record by Director or Rating
    public void searchByDirectorOrRating(String director, double rating) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director) || current.rating == rating) {
                System.out.println("Found: Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movie found with Director '" + director + "' or Rating " + rating);
        }
    }

    // Display all movie records in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No records found!");
            return;
        }
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No records found!");
            return;
        }
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's Rating based on the Movie Title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated successfully for Movie '" + title + "'");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title '" + title + "' not found!");
    }

    public static void main(String[] args) {
        MovieManagement movies = new MovieManagement();

        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movies.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);

        System.out.println("All Movies in Forward Order:");
        movies.displayForward();

        System.out.println("\nAll Movies in Reverse Order:");
        movies.displayReverse();

        System.out.println("\nSearching for movies by Director 'Christopher Nolan' or Rating 9.0:");
        movies.searchByDirectorOrRating("Christopher Nolan", 9.0);

        System.out.println("\nUpdating Rating for 'Interstellar':");
        movies.updateRating("Interstellar", 9.2);

        System.out.println("\nAll Movies After Update:");
        movies.displayForward();

        System.out.println("\nRemoving 'The Dark Knight':");
        movies.removeByTitle("The Dark Knight");

        System.out.println("\nAll Movies After Removal:");
        movies.displayForward();
    }
}
