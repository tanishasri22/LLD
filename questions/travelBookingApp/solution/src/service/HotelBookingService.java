package questions.travelBookingApp.solution.src.service;

import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.UUID;

import questions.travelBookingApp.solution.src.models.Booking;
import questions.travelBookingApp.solution.src.models.HotelBooking;
import questions.travelBookingApp.solution.src.models.User;
import questions.travelBookingApp.solution.src.repository.HotelBookingRepo;

public class HotelBookingService implements TicketService{

    private User user;
    private HotelBooking hotelBookingModel;
    private HotelBookingRepo bookingRepo;

    public HotelBookingService(User user){
        this.user = user;
        bookingRepo = new HotelBookingRepo();
    }
    
    public boolean book(Booking hotelBooking){
        this.hotelBookingModel = (HotelBooking)hotelBooking;

        TreeMap<LocalDateTime, HotelBooking> userBookings = bookingRepo.getAllHotelBookingByUserId(user.getId());
        if(userBookings == null) {
            bookingRepo.createBookingForUser(user, hotelBookingModel);
            System.out.println("First booking created for "+ user.getName());
            System.out
                    .println("Details: Booking confirmed with id " + hotelBookingModel.getId() + " starting at " + hotelBookingModel.getStartTime());

        }
        else{
            LocalDateTime prevStartTime = userBookings.floorKey(hotelBookingModel.getStartTime());
            LocalDateTime nextStartTime = userBookings.ceilingKey(hotelBookingModel.getStartTime());
            LocalDateTime bookingStart = hotelBookingModel.getStartTime();
            LocalDateTime bookingEnd = hotelBookingModel.getEndTime();

            if ((prevStartTime == null || userBookings.get(prevStartTime).getEndTime().isBefore(bookingStart)) && (nextStartTime == null || nextStartTime
                    .isAfter(bookingEnd))) {
                System.out
                        .println("Details: Booking confirmed with id " + hotelBookingModel.getId() + " starting at " + bookingStart);
                bookingRepo.createBookingForUser(user, hotelBookingModel);
            } else {
                System.out.println("Schedule is occupied. Couldn't register!");
                return false;
            }

        }
        return true;
    }

    public boolean cancel(User user, UUID id){
        bookingRepo.deleteBookingByUser(user, hotelBookingModel.getStartTime());
        return true;
    }


}
