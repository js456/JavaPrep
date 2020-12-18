package carrentalsystem.model;

import java.util.Date;

public class Notification {

	int notificationId;
	Date createdOn;
	String content;
	
	public boolean sendNotification() {
		return false;
	}
	
	
}
