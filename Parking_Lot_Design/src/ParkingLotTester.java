import constants.ParkingType;
import constants.PaymentType;
import constants.VehicleType;
import entity.ParkingFloor;
import entity.ParkingLot;
import entity.ParkingSpot;
import entity.Vehicle;
import service.ParkingService;

public class ParkingLotTester {
	public void runTest() throws Exception{
		ParkingLot parkingLot = new ParkingLot("Brooks");
		ParkingService service = ParkingService.getInstance();
		service.setParkingLot(parkingLot);
		ParkingSpot spot1 = new ParkingSpot("A1", ParkingType.COMPACT);
		ParkingSpot spot2 = new ParkingSpot("B1", ParkingType.COMPACT);
		ParkingSpot spot3 = new ParkingSpot("C1", ParkingType.LARGE);
		ParkingSpot spot4 = new ParkingSpot("D1", ParkingType.LARGE);
		ParkingSpot spot5 = new ParkingSpot("A2", ParkingType.LARGE);
		ParkingSpot spot6 = new ParkingSpot("B3", ParkingType.MOTORCYCLE);
		ParkingSpot spot7 = new ParkingSpot("E1", ParkingType.MOTORCYCLE);
		ParkingSpot spot8 = new ParkingSpot("F1", ParkingType.COMPACT);
		ParkingFloor floor1 = new ParkingFloor("1");
		ParkingFloor floor2 = new ParkingFloor("2");
		ParkingFloor floor3 = new ParkingFloor("3");
		parkingLot.addParkingFloor(floor3);
		parkingLot.addParkingFloor(floor2);
		parkingLot.addParkingFloor(floor1);
		floor1.addParkingSpot(spot1);
		floor1.addParkingSpot(spot2);
		floor1.addParkingSpot(spot3);
		floor2.addParkingSpot(spot4);
		floor2.addParkingSpot(spot5);
		floor3.addParkingSpot(spot6);
		floor3.addParkingSpot(spot7);
		floor3.addParkingSpot(spot8);
		Vehicle v1 = new Vehicle("e2ffe33",VehicleType.CAR );
		Vehicle v2 = new Vehicle("dgd33",VehicleType.TRUCK);
		Vehicle v3 = new Vehicle("3ere",VehicleType.MOTORCYCLE );
		service.parkVehicle(v1);
		service.parkVehicle(v2);
		service.parkVehicle(v3);
		
		service.unParkVehicle(v1.getTicket().getSpot(), PaymentType.CASH);
	}
}
