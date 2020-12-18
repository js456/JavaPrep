package movieticketBookingSystem;

import java.util.Date;
import java.util.List;

public class Booking {
	
	private int bookingNumber;
	BookingStatus status;
	Date bookedAt;
	
	List<Seat>showSeat;
	int noOfSeats;
	
	Payment payment;
	
	public boolean makePayment() {
		return false;
	}
	
	public boolean cancel() {
		return false;
	}

	public boolean assignSeats(List<Seat> seats) {
		return false;
	}
}
