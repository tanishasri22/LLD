package questions.travelBookingApp.solution.src.models;

import java.util.UUID;

public abstract class Booking {
    protected String id;
    protected String src;
    protected String dest;
    protected User user;

    Booking(String id, String src, String dest, User user){
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.user = user;
    }

    public String getDest() {
        return dest;
    }

    public String getId() {
        return id;
    }

    public String getSrc() {
        return src;
    }

    public User getUser() {
        return user;
    }
    
}
