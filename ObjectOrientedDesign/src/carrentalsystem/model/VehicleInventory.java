package carrentalsystem.model;

import java.util.List;
import java.util.Map;

public class VehicleInventory extends VehicleSearch{

	Map<String, List<Vehicle>>vehicleTypeMap;
	Map<String, List<Vehicle>>vehicleModelsMap;
	
	@Override
	List<Vehicle> searchByType(String vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<Vehicle> searchByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

}
