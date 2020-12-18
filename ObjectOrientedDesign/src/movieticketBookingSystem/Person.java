package movieticketBookingSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
	
	String name;
	Address address;
	String email;
	String phone;
	
	Account account;

}

class Customer extends Person{
	
	public boolean makeBooking(Booking booking) {
		return false;
	}
	
	public List<Booking> getBookings(){
		return new ArrayList<Booking>();
	}
}