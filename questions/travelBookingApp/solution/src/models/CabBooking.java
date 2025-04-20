package questions.travelBookingApp.solution.src.models;

public class CabBooking extends Booking {
    private String type;

    CabBooking(String id, String src, String dest, User user, String rating, String type){
        super(id, src, dest, user);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
