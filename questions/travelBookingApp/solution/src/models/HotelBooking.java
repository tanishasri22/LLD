package questions.travelBookingApp.solution.src.models;

import java.time.LocalDateTime;

public class HotelBooking extends Booking {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int rating;

    public HotelBooking(String id, String src, String dest, User user, String rating, LocalDateTime startTime, 
            LocalDateTime endTime){
        super(id, src, dest, user);
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public int getRating() {
        return rating;
    }

   public LocalDateTime getStartTime() {
       return startTime;
   }

   public LocalDateTime getEndTime() {
       return endTime;
   }
}
