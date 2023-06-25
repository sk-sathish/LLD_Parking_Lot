package service;

import constants.ParkingType;
import constants.VehicleType;

public class VehicleService {
	private static VehicleService instance;
	public static VehicleService getInstance() {
		if(instance == null) {
			instance = new VehicleService();
		}
		return instance;
	}
	private VehicleService() {
		
	}
	public ParkingType getVehicleParkingType(VehicleType vehicleType) throws Exception {
		if(vehicleType.equals(VehicleType.CAR)) {
			return ParkingType.COMPACT;
		}
		else if(vehicleType.equals(VehicleType.VAN)) {
			return ParkingType.LARGE;
		}
		else if(vehicleType.equals(VehicleType.TRUCK)) {
			return ParkingType.LARGE;
		}
		else if(vehicleType.equals(vehicleType.MOTORCYCLE)) {
			return ParkingType.MOTORCYCLE;
		}
		else {
			throw new Exception("Invalid Vehicle Type");
		}
	}
}
