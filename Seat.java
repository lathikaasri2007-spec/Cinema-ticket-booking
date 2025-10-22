package ticketbooking;

public class Seat {
    private int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() { return seatNumber; }
    public boolean isBooked() { return isBooked; }

    public void bookSeat() { this.isBooked = true; }
    public void cancelSeat() { this.isBooked = false; }

    @Override
    public String toString() {
        return "Seat " + seatNumber + (isBooked ? " (Booked)" : " (Available)");
    }
}
