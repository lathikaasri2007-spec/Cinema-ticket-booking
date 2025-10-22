
package ticketbooking;
import java.util.*;

public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private String showTime;
    private ArrayList<Seat> seats;

    public Show(int showId, Movie movie, Screen screen, String showTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showTime = showTime;
        seats = new ArrayList<>();
        for (int i = 1; i <= screen.getTotalSeats(); i++) {
            seats.add(new Seat(i));
        }
    }

    public int getShowId() { return showId; }
    public Movie getMovie() { return movie; }
    public Screen getScreen() { return screen; }
    public String getShowTime() { return showTime; }
    public ArrayList<Seat> getSeats() { return seats; }

    public void displayAvailability() {
        System.out.println("Show ID: " + showId + " | Movie: " + movie.getTitle() + " | Time: " + showTime);
        long available = seats.stream().filter(s -> !s.isBooked()).count();
        System.out.println("Available Seats: " + available + " / " + seats.size());
    }

    public Seat getSeat(int number) {
        if (number > 0 && number <= seats.size()) return seats.get(number - 1);
        return null;
    }

    @Override
    public String toString() {
        return showId + ". " + movie.getTitle() + " at " + showTime + " (" + screen.getName() + ")";
    }
}

