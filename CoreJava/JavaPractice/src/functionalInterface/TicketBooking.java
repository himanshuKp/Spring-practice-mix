package functionalInterface;

public class TicketBooking {
    private int availableTickets = 10;

    public synchronized void bookTicket(int ticket){
        if (availableTickets >= ticket) {
            availableTickets -= ticket;
            System.out.println("Booked: "+ticket+" tickets, Remaining tickets: "+availableTickets);
        } else {
            System.out.println("Not enough tickets available to book: "+ticket);
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
