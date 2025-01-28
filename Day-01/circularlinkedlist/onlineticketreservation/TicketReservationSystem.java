package circularlinkedlist.onlineticketreservation;



public class TicketReservationSystem {
    Ticket head;

    TicketReservationSystem() {
        head = null;
    }

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Make it circular
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    void removeTicket(int ticketId) {
        if (head == null) return;

        Ticket current = head;
        Ticket previous = null;

        do {
            if (current.ticketId == ticketId) {
                if (previous == null) { // Removing the head
                    if (current.next == head) { // Only one element
                        head = null;
                    } else {
                        Ticket last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        last.next = current.next;
                        head = current.next;
                    }
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    Ticket searchTicket(String searchKey) {  // Searches by customer or movie name
        if (head == null) return null;

        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(searchKey) || current.movieName.equalsIgnoreCase(searchKey)) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null;
    }

    int countBookedTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Alice", "Action Movie", "A1", "2023-10-27 10:00");
        system.addTicket(2, "Bob", "Comedy Movie", "B2", "2023-10-27 14:00");
        system.addTicket(3, "Charlie", "Action Movie", "C3", "2023-10-27 18:00");

        System.out.println("Current Booked Tickets:");
        system.displayTickets();
        System.out.println();

        Ticket foundTicket = system.searchTicket("Bob");
        if (foundTicket != null) {
            System.out.println("Found ticket: " + foundTicket.ticketId + " | " + foundTicket.customerName);
        }

        System.out.println("\nTotal Booked Tickets: " + system.countBookedTickets());

        system.removeTicket(2);
        System.out.println("\nTickets after removing ticket 2:");
        system.displayTickets();

        foundTicket = system.searchTicket("Action Movie");
        if (foundTicket != null) {
            System.out.println("\nFound ticket by movie name: " + foundTicket.ticketId + " | " + foundTicket.customerName);
        }

    }
}