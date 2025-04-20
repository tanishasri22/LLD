package questions.travelBookingApp.solution;

import java.time.LocalDateTime;
import java.util.UUID;

import questions.travelBookingApp.solution.src.models.Booking;
import questions.travelBookingApp.solution.src.models.HotelBooking;
import questions.travelBookingApp.solution.src.models.User;
import questions.travelBookingApp.solution.src.service.HotelBookingService;

public class solution {
    public static void main(String[] args) {
        User user1 = new User(UUID.randomUUID(), "Tanisha", "tanishasri01@gmail.com");
        User user2 = new User(UUID.randomUUID(), "Ananya", "ananya@gmail.com");

        HotelBookingService service1 = new HotelBookingService(user1);
        HotelBookingService service2 = new HotelBookingService(user2);

        LocalDateTime time = LocalDateTime.now().plusDays(9);

        System.out.println("\n----User1----\n");
        Booking hotelBooking1 = new HotelBooking(UUID.randomUUID().toString(), "Delhi", "Azamgarh", user1, "5", LocalDateTime.now(), LocalDateTime.now().plusDays(5L));
        Booking hotelBooking2 = new HotelBooking(UUID.randomUUID().toString(), "Kolkata", "Mumbai", user1, "2",
                time, LocalDateTime.now().plusDays(9));
        Booking hotelBooking3 = new HotelBooking(UUID.randomUUID().toString(), "Kolkata", "Mumbai", user1, "2",
                time, LocalDateTime.now().plusDays(10));

        service1.book(hotelBooking1);
        service1.book(hotelBooking2);
        service1.book(hotelBooking3);

        System.out.println("\n----User2----\n");

        Booking hotelBooking4 = new HotelBooking(UUID.randomUUID().toString(), "Delhi", "Azamgarh", user2, "5",
                LocalDateTime.now(), LocalDateTime.now().plusDays(5L));
        Booking hotelBooking5 = new HotelBooking(UUID.randomUUID().toString(), "Kolkata", "Mumbai", user2, "2",
                time, LocalDateTime.now().plusDays(9));
        Booking hotelBooking6 = new HotelBooking(UUID.randomUUID().toString(), "Kolkata", "Mumbai", user2, "2",
                time, LocalDateTime.now().plusDays(10));

        service2.book(hotelBooking4);
        service2.book(hotelBooking5);
        service2.book(hotelBooking6);
    }
}
