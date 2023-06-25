package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.ParkingType;
import exception.ParkingSpotNameDuplicateException;

public class ParkingFloor {
	String floorIdentifier;
	List<ParkingSpot> parkingSpots;
	Map<String, ParkingSpot> map;
	Map<ParkingType, List<ParkingSpot>> availableSpots;
	ParkingDisplayBoard parkingDisplayBoard;
	CustomerInfoPortal customerInfoPortal;
	public ParkingFloor(String floorIdentifier) {
		super();
		this.floorIdentifier = floorIdentifier;
		map = new HashMap<String, ParkingSpot>();
		parkingSpots = new ArrayList<ParkingSpot>();
		parkingDisplayBoard = new ParkingDisplayBoard(this);
		customerInfoPortal = new CustomerInfoPortal();
		availableSpots = new HashMap<ParkingType, List<ParkingSpot>>();
		for(ParkingType type: ParkingType.values()) {
			availableSpots.put(type, new ArrayList<ParkingSpot>());
		}
	}
	public void addParkingSpot(ParkingSpot parkingSpot) throws ParkingSpotNameDuplicateException {
		if(map.containsKey(parkingSpot.getLocationIdentifer())) {
			throw new ParkingSpotNameDuplicateException("Same Parking Spot Name Exist");
		}
		else {
			map.put(parkingSpot.getLocationIdentifer(), parkingSpot);
			parkingSpots.add(parkingSpot);
			availableSpots.get(parkingSpot.getType()).add(parkingSpot);
			parkingSpot.setParkingFloor(this);
		}
	}
	public String getFloorIdentifier() {
		return floorIdentifier;
	}
	public void setFloorIdentifier(String floorIdentifier) {
		this.floorIdentifier = floorIdentifier;
	}
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}
	public void setParkingSpots(List<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}
	public ParkingDisplayBoard getParkingDisplayBoard() {
		return parkingDisplayBoard;
	}
	public void setParkingDisplayBoard(ParkingDisplayBoard parkingDisplayBoard) {
		this.parkingDisplayBoard = parkingDisplayBoard;
	}
	public CustomerInfoPortal getCustomerInfoPortal() {
		return customerInfoPortal;
	}
	public void setCustomerInfoPortal(CustomerInfoPortal customerInfoPortal) {
		this.customerInfoPortal = customerInfoPortal;
	}
	public Map<ParkingType, List<ParkingSpot>> getAvailableSpots() {
		return availableSpots;
	}
	public void setAvailableSpots(Map<ParkingType, List<ParkingSpot>> availableSpots) {
		this.availableSpots = availableSpots;
	}
	public String toString() {
		return "Parking Floor - "+getFloorIdentifier();
	}
}
