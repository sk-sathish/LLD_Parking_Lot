package entity;

import constants.VehicleType;

public class Vehicle {
	String number;
	ParkingTicket ticket;
	VehicleType vehicleType;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ParkingTicket getTicket() {
		return ticket;
	}
	public void setTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}
	public Vehicle(String number, VehicleType vehicleType) {
		super();
		this.number = number;
		this.vehicleType = vehicleType;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String toString() {
		return "Vehicle "+getNumber();
	}
}
