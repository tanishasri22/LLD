package questions.travelBookingApp.solution.src.service;

import java.util.UUID;

import questions.travelBookingApp.solution.src.models.Booking;
import questions.travelBookingApp.solution.src.models.User;

public interface TicketService {
    boolean book(Booking booking);
    boolean cancel(User user, UUID id);
}
