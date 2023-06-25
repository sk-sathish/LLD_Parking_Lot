package entity;

import java.util.Date;

import constants.TicketStatus;

public class ParkingTicket {
	Vehicle vehicle;
	Date entryTime;
	Date exitTime;
	TicketStatus status;
	ParkingSpot spot;
	
	public ParkingTicket(Vehicle vehicle, Date entryTime, TicketStatus status, ParkingSpot spot) {
		super();
		this.vehicle = vehicle;
		this.entryTime = entryTime;
		this.status = status;
		this.spot = spot;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getExitTime() {
		return exitTime;
	}
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}
	public TicketStatus getStatus() {
		return status;
	}
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	public ParkingSpot getSpot() {
		return spot;
	}
	public void setSpot(ParkingSpot spot) {
		this.spot = spot;
	}
	
}
