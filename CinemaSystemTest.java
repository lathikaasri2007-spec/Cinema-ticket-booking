package ticketbooking;


import java.util.*;

public class CinemaSystemTest {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Movie> movies = new ArrayList<>();
    private static ArrayList<Screen> screens = new ArrayList<>();
    private static ArrayList<Show> shows = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<ConcessionOrder> orders = new ArrayList<>();

    public static void main(String[] args) {
        screens.add(new Screen(1, "Screen A", 10)); 
        int choice;
        do {
            System.out.println("\n=== CINEMA TICKETING SYSTEM ===");
            System.out.println("1. Add Movie");
            System.out.println("2. Schedule Show");
            System.out.println("3. Add Customer");
            System.out.println("4. Book Seats");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Order Concessions");
            System.out.println("7. Display Shows & Availability");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addMovie();
                case 2 -> scheduleShow();
                case 3 -> addCustomer();
                case 4 -> bookSeats();
                case 5 -> cancelBooking();
                case 6 -> orderConcessions();
                case 7 -> displayShows();
                case 8 -> System.out.println("Thank you! Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

    private static void addMovie() {
        sc.nextLine();
        System.out.print("Enter movie title: ");
        String title = sc.nextLine();
        System.out.print("Enter duration (mins): ");
        int duration = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter genre: ");
        String genre = sc.nextLine();
        movies.add(new Movie(movies.size() + 1, title, duration, genre));
        System.out.println("Movie added successfully!");
    }

    private static void scheduleShow() {
        if (movies.isEmpty()) { System.out.println("No movies found."); return; }
        System.out.println("Available Movies:");
        for (Movie m : movies) m.displayMovie();
        System.out.print("Select movie ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Movie movie = movies.get(id - 1);
        System.out.print("Enter show time (e.g. 6:30 PM): ");
        String time = sc.nextLine();
        Show show = new Show(shows.size() + 1, movie, screens.get(0), time);
        shows.add(show);
        System.out.println("Show scheduled successfully!");
    }

    private static void addCustomer() {
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        customers.add(new Customer(customers.size() + 1, name, phone));
        System.out.println("Customer added successfully!");
    }

    private static void bookSeats() {
        if (shows.isEmpty() || customers.isEmpty()) {
            System.out.println("Add shows and customers first!");
            return;
        }

        System.out.println("Available Shows:");
        for (Show s : shows) s.displayAvailability();
        System.out.print("Select Show ID: ");
        int showId = sc.nextInt();
        Show show = shows.get(showId - 1);

        System.out.println("Enter Customer ID: ");
        for (Customer c : customers)
            System.out.println(c.getCustomerId() + ". " + c.getName());
        int custId = sc.nextInt();
        Customer customer = customers.get(custId - 1);

        System.out.print("Enter number of seats to book: ");
        int count = sc.nextInt();
        ArrayList<Seat> booked = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter seat number: ");
            int seatNo = sc.nextInt();
            Seat s = show.getSeat(seatNo);
            if (s != null && !s.isBooked()) {
                s.bookSeat();
                booked.add(s);
            } else {
                System.out.println("Seat not available!");
            }
        }

        double amount = count * 200; //
        Booking b = new Booking(bookings.size() + 1, customer, show, booked, amount);
        b.confirmPayment();
        bookings.add(b);
        b.generateReceipt();
    }

    private static void cancelBooking() {
        if (bookings.isEmpty()) { System.out.println("No bookings found."); return; }
        System.out.print("Enter Booking ID to cancel: ");
        int id = sc.nextInt();
        if (id <= bookings.size()) {
            bookings.get(id - 1).cancelBooking();
        } else System.out.println("Invalid Booking ID.");
    }

    private static void orderConcessions() {
        if (customers.isEmpty()) { System.out.println("Add customers first!"); return; }
        System.out.println("Enter Customer ID: ");
        for (Customer c : customers)
            System.out.println(c.getCustomerId() + ". " + c.getName());
        int id = sc.nextInt();
        Customer customer = customers.get(id - 1);
        ConcessionOrder order = new ConcessionOrder(orders.size() + 1, customer);

        char more;
        do {
            sc.nextLine();
            System.out.print("Enter item name: ");
            String item = sc.nextLine();
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            System.out.print("Enter price per item: ");
            double price = sc.nextDouble();
            order.addItem(item, qty, price);
            System.out.print("Add more items? (y/n): ");
            more = sc.next().charAt(0);
        } while (more == 'y' || more == 'Y');

        orders.add(order);
        order.generateReceipt();
    }

    private static void displayShows() {
        if (shows.isEmpty()) { System.out.println("No shows available."); return; }
        for (Show s : shows) {
            s.displayAvailability();
            System.out.println();
        }
    }
}

