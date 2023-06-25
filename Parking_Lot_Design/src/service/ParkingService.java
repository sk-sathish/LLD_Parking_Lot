package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import constants.ParkingType;
import constants.PaymentType;
import constants.ServiceType;
import constants.TicketStatus;
import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.ParkingTicket;
import entity.Vehicle;
import helper.FeeStrategyHelper;
import helper.PaymentStrategyHelper;

public class ParkingService {
	private static ParkingService instance;
	public static ParkingService getInstance() {
		if(instance == null) {
			instance = new ParkingService();
		}
		return instance;
	}
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	private ParkingService() {
		activeTickets = new ArrayList<ParkingTicket>();
	}
	List<ParkingTicket> activeTickets;
	boolean isParkingFull;
	ParkingLot parkingLot;
	public void parkVehicle(Vehicle vehicle) throws Exception {
		boolean isParked = false;
		for(ParkingFloor floor: parkingLot.getParkingFloors()) {
			Map<ParkingType, List<ParkingSpot>> availableSpots = floor.getAvailableSpots();
			ParkingType compatibleParkingType = VehicleService.getInstance().getVehicleParkingType(vehicle.getVehicleType());
			List<ParkingSpot> spots = availableSpots.get(compatibleParkingType);
			if(spots.size() > 0) {
				ParkingSpot firstSpot = spots.get(0);
				assignParkingTicket(vehicle, firstSpot);
				firstSpot.parkVehicle(vehicle);
				isParked = true;
				break;
			}
		}
		if(!isParked) {
			throw new Exception("Cannot Park, Parking is Full");
		}
	}
	public void assignParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
		ParkingTicket ticket = new ParkingTicket(vehicle, new Date(), TicketStatus.CREATED, parkingSpot);
		vehicle.setTicket(ticket);
		activeTickets.add(ticket);
	}
	public void unParkVehicle(ParkingSpot parkingSpot, PaymentType paymentType) throws Exception {
		if(!parkingSpot.isOccupied()) {
			throw new Exception("Parking Spot is not occupied");			
		}
		Vehicle vehicle = parkingSpot.getVehicle();
		ParkingTicket ticket = vehicle.getTicket();
		if(ticket.getStatus().equals(TicketStatus.PAID)) {
			throw new Exception("Ticket is already paid");						
		}
		Date entryTime = ticket.getEntryTime();
		Date exitTime = new Date();
		long durationInMillis = exitTime.getTime()-entryTime.getTime();
		long durationInMinutes = durationInMillis/(60*1000);
		IFeeStrategy feeStrategy = FeeStrategyHelper.getFeeStrategy(ServiceType.PARK);
		double fee = feeStrategy.calculateFee(durationInMinutes);
		IPaymentStrategy paymentStrategy = PaymentStrategyHelper.getPaymentStrategy(paymentType);
		paymentStrategy.makePayment(fee);
		closeParkingTicket(ticket);
		parkingSpot.unparkVehicle();
	}
	public void closeParkingTicket(ParkingTicket ticket) {
		ticket.setStatus(TicketStatus.PAID);
		ticket.setExitTime(new Date());
		activeTickets.remove(ticket);
	}
}
