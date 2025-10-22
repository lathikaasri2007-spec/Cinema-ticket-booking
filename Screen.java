package ticketbooking;

public class Screen {
    private int screenId;
    private String name;
    private int totalSeats;

    public Screen(int screenId, String name, int totalSeats) {
        this.screenId = screenId;
        this.name = name;
        this.totalSeats = totalSeats;
    }

    public int getScreenId() { return screenId; }
    public String getName() { return name; }
    public int getTotalSeats() { return totalSeats; }

    @Override
    public String toString() {
        return name + " (Seats: " + totalSeats + ")";
    }
}