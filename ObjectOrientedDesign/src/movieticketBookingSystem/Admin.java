package movieticketBookingSystem;

public class Admin  extends Person{

	public boolean addShow(ShowTimings show) {
		return false;
	}
	public boolean addMovie(Movie movie) {
		return false;
	}
	public boolean blockUser(Customer customer) {
		return false;
	}
}
