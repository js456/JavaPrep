package carrentalsystem.model;

import java.util.Date;
import java.util.List;

public class Vehicle {

	String registrationNumber;
	int parkingStallNumber;
	Barcode barcode;
	String make;
	String model;
	int milage;
	int manufecturingYear;
	List<VehicleLog>vehicleLogs;
	public void reservVehicle() {
		
	}
}

class SUV extends Vehicle{}
class Car extends Vehicle{}
class Van extends Vehicle{}
class Motorcycle extends Vehicle{}
class Truck extends Vehicle{}

class VehicleLog{
	int id;
	Date creationDate;
	VehicleLogType logType;
	String desc;
}