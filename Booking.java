package ticketbooking;

import java.util.*;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Show show;
    private ArrayList<Seat> bookedSeats;
    private double totalAmount;
    private boolean isPaid;

    public Booking(int bookingId, Customer customer, Show show, ArrayList<Seat> bookedSeats, double totalAmount) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.totalAmount = totalAmount;
        this.isPaid = false;
    }

    public int getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Show getShow() { return show; }

    public void confirmPayment() {
        isPaid = true;
        System.out.println("Payment confirmed for booking #" + bookingId);
    }

    public void cancelBooking() {
        for (Seat s : bookedSeats) {
            s.cancelSeat();
        }
        System.out.println("Booking #" + bookingId + " cancelled and seats released.");
    }

    public void generateReceipt() {
        System.out.println("\n=== BOOKING RECEIPT ===");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Movie: " + show.getMovie().getTitle());
        System.out.print("Seats: ");
        for (Seat s : bookedSeats) System.out.print(s.getSeatNumber() + " ");
        System.out.println("\nTotal Amount: ₹" + totalAmount);
        System.out.println("Payment: " + (isPaid ? "Confirmed" : "Pending"));
        System.out.println("=========================\n");
    }
}