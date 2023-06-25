package entity;

import java.util.List;
import java.util.Map;

import constants.ParkingType;

public class ParkingDisplayBoard {
	ParkingFloor parkingFloor;
	
	public ParkingDisplayBoard(ParkingFloor parkingFloor) {
		super();
		this.parkingFloor = parkingFloor;
		
	}
	public void display() {
		Map<ParkingType, List<ParkingSpot>> map = parkingFloor.getAvailableSpots();
		System.out.println(parkingFloor+ " Display Board");
		for(ParkingType type: ParkingType.values()) {
			List<ParkingSpot> list = map.get(type);
			if(list.size() > 0) {
				System.out.println(type+ " " +list.get(0));
			}
			else {
				System.out.println(type+ " FULL");				
			}
		}
	}
}
