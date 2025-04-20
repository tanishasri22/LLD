package questions.travelBookingApp.solution.src.repository;

import java.time.LocalDateTime;
import java.util.*;

import questions.travelBookingApp.solution.src.models.HotelBooking;
import questions.travelBookingApp.solution.src.models.User;

public class HotelBookingRepo {
    private static final HashMap< UUID, TreeMap<LocalDateTime, HotelBooking>> hotelBookings = new HashMap<>();//startTime->bookings

    public HotelBookingRepo() {
    }
    
    public void createBookingForUser(User user, HotelBooking hotelBooking) {
        if(hotelBookings.containsKey(user.getId())){
            TreeMap<LocalDateTime, HotelBooking> entry = hotelBookings.get(user.getId());
            entry.put(hotelBooking.getStartTime(), hotelBooking);
        }else{
            TreeMap<LocalDateTime, HotelBooking> entry = new TreeMap<>();
            entry.put(hotelBooking.getEndTime(), hotelBooking);
            hotelBookings.put(user.getId(), entry);
        }
    }

    public TreeMap<LocalDateTime, HotelBooking> getAllHotelBookingByUserId(UUID userId){
        if(hotelBookings.containsKey(userId)){
            return hotelBookings.get(userId);
        }
        return null;
    }

    public void deleteBookingByUser(User user, LocalDateTime startTime){
        hotelBookings.get(user.getId()).remove(startTime);
    }

}
