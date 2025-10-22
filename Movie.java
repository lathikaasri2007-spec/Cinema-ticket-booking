package ticketbooking;

public class Movie {
    private int movieId;
    private String title;
    private int duration;
    private String genre;

    public Movie(int movieId, String title, int duration, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    public int getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public String getGenre() { return genre; }

    public void displayMovie() {
        System.out.println(movieId + ". " + title + " (" + genre + ", " + duration + " mins)");
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}
