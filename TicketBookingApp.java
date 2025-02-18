class TicketBookingSystem {
    private int totalSeats;
    private int bookedSeats;

    public TicketBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public synchronized boolean bookTicket(String customerName, boolean isVIP) {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
            System.out.println(customerName + " successfully booked a seat.");
            return true;
        } else {
            System.out.println("Sorry " + customerName + ", no seats available.");
            return false;
        }
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }
}

class Customer extends Thread {
    private String customerName;
    private TicketBookingSystem bookingSystem;
    private boolean isVIP;

    public Customer(String customerName, TicketBookingSystem bookingSystem, boolean isVIP) {
        this.customerName = customerName;
        this.bookingSystem = bookingSystem;
        this.isVIP = isVIP;
    }

    @Override
    public void run() {
        if (isVIP) {
            System.out.println(customerName + " is a VIP. Processing VIP booking...");
        } else {
            System.out.println(customerName + " is a regular customer. Processing booking...");
        }

        boolean booked = bookingSystem.bookTicket(customerName, isVIP);

        if (booked) {
            System.out.println(customerName + " has successfully booked the ticket.");
        } else {
            System.out.println(customerName + " failed to book a ticket due to no available seats.");
        }
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5);

        Customer customer1 = new Customer("John", bookingSystem, true);  // VIP customer
        Customer customer2 = new Customer("Jane", bookingSystem, false);  // Regular customer
        Customer customer3 = new Customer("Sam", bookingSystem, false);  // Regular customer
        Customer customer4 = new Customer("Mia", bookingSystem, true);   // VIP customer
        Customer customer5 = new Customer("Alex", bookingSystem, false); // Regular customer
        Customer customer6 = new Customer("Oliver", bookingSystem, true); // VIP customer

        customer1.setPriority(Thread.MAX_PRIORITY);
        customer2.setPriority(Thread.NORM_PRIORITY);
        customer3.setPriority(Thread.NORM_PRIORITY);
        customer4.setPriority(Thread.MAX_PRIORITY);
        customer5.setPriority(Thread.NORM_PRIORITY);
        customer6.setPriority(Thread.MAX_PRIORITY);

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
        customer6.start();
    }
}