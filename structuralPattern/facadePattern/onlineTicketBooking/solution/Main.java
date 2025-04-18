package structuralPattern.facadePattern.onlineTicketBooking.solution;

import java.util.*;

// ==== Domain Classes ====
class User {
    private String id;
    private String name;
    private String email;
    private List<Booking> bookings = new ArrayList<>();
    private int loyaltyPoints = 0;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void addPoints(int points) {
        this.loyaltyPoints += points;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}

abstract class Booking {
    protected String id;
    protected Date date;
    protected double price;
    protected User user;

    public Booking(String id, Date date, double price, User user) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user = user;
    }

    public abstract boolean cancel();

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return this.getClass().getSimpleName() + " | ID: " + id + " | ₹" + price;
    }
}

class FlightBooking extends Booking {
    private String flightNumber, airline, departure, arrival;

    public FlightBooking(String id, Date date, double price, User user,
            String flightNumber, String airline, String departure, String arrival) {
        super(id, date, price, user);
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
    }

    public void bookFlight() {
        System.out.println("✅ Flight booked: " + flightNumber + " by " + airline);
    }

    @Override
    public boolean cancel() {
        System.out.println("❌ Flight booking canceled: " + flightNumber);
        return true;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | " + airline + ": " + departure + " → " + arrival;
    }
}

class HotelBooking extends Booking {
    private String hotelName;
    private Date checkIn, checkOut;

    public HotelBooking(String id, Date date, double price, User user,
            String hotelName, Date checkIn, Date checkOut) {
        super(id, date, price, user);
        this.hotelName = hotelName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void bookHotel() {
        System.out.println("✅ Hotel booked: " + hotelName);
    }

    @Override
    public boolean cancel() {
        System.out.println("❌ Hotel booking canceled: " + hotelName);
        return true;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | " + hotelName + ": " + checkIn + " → " + checkOut;
    }
}

class CabBooking extends Booking {
    private String pickupLocation, dropLocation, driverName;

    public CabBooking(String id, Date date, double price, User user,
            String pickupLocation, String dropLocation, String driverName) {
        super(id, date, price, user);
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.driverName = driverName;
    }

    public void bookCab() {
        System.out.println("✅ Cab booked with driver: " + driverName);
    }

    @Override
    public boolean cancel() {
        System.out.println("❌ Cab booking canceled: " + driverName);
        return true;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Driver: " + driverName + " (" + pickupLocation + " → " + dropLocation + ")";
    }
}

// ==== Subsystem Services ====
class SearchService {
    public void searchAll() {
        System.out.println("🔍 Searching flights, hotels, and cabs...");
    }
}

class PaymentService {
    public double applyDiscount(double amount) {
        return amount >= 5000 ? amount * 0.9 : amount;
    }

    public boolean pay(User user, double amount) {
        double finalAmount = applyDiscount(amount);
        int earnedPoints = (int) (finalAmount / 100);
        user.addPoints(earnedPoints);

        System.out.println("💰 Paid ₹" + finalAmount + " by user " + user.getName());
        System.out.println("🏅 Loyalty Points Earned: " + earnedPoints);
        return true;
    }
}

class NotificationService {
    public void sendBookingConfirmation(User user, Booking booking) {
        System.out.println("📧 Booking confirmation sent to " + user.getEmail());
    }

    public void sendCancellation(User user, Booking booking) {
        System.out.println("📧 Cancellation sent to " + user.getEmail());
    }

    public void sendItinerary(User user) {
        System.out.println("\n📄 Simulated PDF Itinerary for " + user.getName() + ":");
        for (Booking b : user.getBookings()) {
            System.out.println("📝 " + b.getDetails());
        }
        System.out.println("🏅 Total Loyalty Points: " + user.getLoyaltyPoints());
        System.out.println("----------------------------------------");
    }
}

// ==== Facade ====
class BookingManager {
    private SearchService searchService = new SearchService();
    private PaymentService paymentService = new PaymentService();
    private NotificationService notificationService = new NotificationService();

    public FlightBooking bookFlight(User user, String flightNumber, String airline, String from, String to) {
        FlightBooking fb = new FlightBooking(UUID.randomUUID().toString(), new Date(), 6000, user,
                flightNumber, airline, from, to);
        fb.bookFlight();
        if (paymentService.pay(user, fb.price)) {
            notificationService.sendBookingConfirmation(user, fb);
            user.addBooking(fb);
        }
        return fb;
    }

    public HotelBooking bookHotel(User user, String hotelName, Date checkIn, Date checkOut) {
        HotelBooking hb = new HotelBooking(UUID.randomUUID().toString(), new Date(), 3500, user,
                hotelName, checkIn, checkOut);
        hb.bookHotel();
        if (paymentService.pay(user, hb.price)) {
            notificationService.sendBookingConfirmation(user, hb);
            user.addBooking(hb);
        }
        return hb;
    }

    public CabBooking bookCab(User user, String pickup, String drop, String driver) {
        CabBooking cb = new CabBooking(UUID.randomUUID().toString(), new Date(), 1000, user,
                pickup, drop, driver);
        cb.bookCab();
        if (paymentService.pay(user, cb.price)) {
            notificationService.sendBookingConfirmation(user, cb);
            user.addBooking(cb);
        }
        return cb;
    }

    public void cancelBooking(User user, Booking booking) {
        if (booking.cancel()) {
            notificationService.sendCancellation(user, booking);
            user.removeBooking(booking);
        }
    }

    public void generateItinerary(User user) {
        notificationService.sendItinerary(user);
    }
}

// ==== Main Application ====
public class Main {
    public static void main(String[] args) {
        User user = new User("U1", "Tanisha", "tanisha@example.com");
        BookingManager manager = new BookingManager();

        FlightBooking fb = manager.bookFlight(user, "AI202", "Air India", "Delhi", "Mumbai");
        HotelBooking hb = manager.bookHotel(user, "Leela Palace", new Date(), new Date());
        CabBooking cb = manager.bookCab(user, "Airport", "Hotel", "Ravi");

        System.out.println("\n🗒 Cancelling Hotel Booking...");
        manager.cancelBooking(user, hb);

        manager.generateItinerary(user);
    }
}
