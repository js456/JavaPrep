package carrentalsystem.model;

import java.util.List;

public abstract class VehicleSearch {

	abstract List<Vehicle> searchByType(String vehicleType);
	abstract List<Vehicle> searchByModel(String model);
}
