package carrentalsystem.model;

public class Account extends Person{
	
	int id;
	String password;
	AccountStatus status;
	Person person;
	
	public boolean resetPassword() {
		return false;
	}
}
