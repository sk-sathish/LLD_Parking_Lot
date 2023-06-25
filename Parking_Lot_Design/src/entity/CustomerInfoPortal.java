package entity;

import constants.PaymentType;
import service.ParkingService;

public class CustomerInfoPortal {
	public void makePaymentForVehicle(Vehicle vehicle, PaymentType paymentType) throws Exception {
		ParkingService.getInstance().unParkVehicle(vehicle.getTicket().getSpot(), paymentType);
	}
}
