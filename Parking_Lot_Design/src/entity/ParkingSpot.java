package entity;

import constants.ParkingType;
import exception.ParkingSpotOccupiedException;

public class ParkingSpot{
	String locationIdentifer;
	boolean isOccupied;
	private ElectricPanel electricPanel;
	Vehicle vehicle;
	ParkingType type;
	private ParkingFloor parkingFloor;
	public ParkingSpot(String locationIdentifer) {
		super();
		this.locationIdentifer = locationIdentifer;
	}
	public ParkingSpot(String locationIdentifer, ParkingType type) {
		super();
		this.locationIdentifer = locationIdentifer;
		this.type = type;
	}
	public ParkingSpot(String locationIdentifer, ElectricPanel electricPanel) {
		super();
		this.locationIdentifer = locationIdentifer;
		this.electricPanel = electricPanel;
	}
	public ParkingType getType() {
		return type;
	}
	public void setType(ParkingType type) {
		this.type = type;
	}
	public void parkVehicle(Vehicle vehicle) throws Exception {
		if(!isOccupied) {
			this.vehicle = vehicle;
			vehicle.getTicket().setSpot(this);
			isOccupied = true;
			parkingFloor.getAvailableSpots().get(type).remove(this);
			System.out.println(vehicle+" parked at "+this);
		}
		else {
			throw new ParkingSpotOccupiedException("Parking Spot is already occupied");
		}
	}
	public void unparkVehicle() throws Exception {
		if(isOccupied) {
			parkingFloor.getAvailableSpots().get(type).add(this);
			System.out.println(vehicle+" unparked");
			this.vehicle = null;
			isOccupied = false;
		}
		else {
			throw new Exception("Parking Spot is empty");
		}
	}
	public boolean hasElectricPanel() {
		return electricPanel!=null;
	}
	public String getLocationIdentifer() {
		return locationIdentifer;
	}
	public void setLocationIdentifer(String locationIdentifer) {
		this.locationIdentifer = locationIdentifer;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public ElectricPanel getElectricPanel() {
		return electricPanel;
	}
	public void setElectricPanel(ElectricPanel electricPanel) {
		this.electricPanel = electricPanel;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingFloor getParkingFloor() {
		return parkingFloor;
	}
	public void setParkingFloor(ParkingFloor parkingFloor) {
		this.parkingFloor = parkingFloor;
	}
	public String toString() {
		return "Parking Spot-" +locationIdentifer+" floor "+parkingFloor;
	}
}
