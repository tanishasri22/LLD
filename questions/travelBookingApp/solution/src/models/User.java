package questions.travelBookingApp.solution.src.models;

import java.time.LocalDateTime;
import java.util.*;

public class User {
    private UUID id;
    private String name;
    private String email;
    // private HashMap<LocalDateTime, HotelBooking> hotelBookings;
    // private HashMap<LocalDateTime, FlightBooking> flightBookings;
    // private HashMap<LocalDateTime, CabBooking> cabBookings;
    
    public User(UUID id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        // hotelBookings = new HashMap<>();
        // flightBookings = new HashMap<>();
        // cabBookings = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    // public HashMap<LocalDateTime, CabBooking> getCabBookings() {
    //     return cabBookings;
    // }

    // public HashMap<LocalDateTime, FlightBooking> getFlightBookings() {
    //     return flightBookings;
    // }

    // public HashMap<LocalDateTime, HotelBooking> getHotelBookings() {
    //     return hotelBookings;
    // }
    
}
