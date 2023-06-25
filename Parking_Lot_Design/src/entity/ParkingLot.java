package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.ParkingFloorNameDuplicateException;

public class ParkingLot {
	private List<ParkingFloor> parkingFloors;
	private EntrancePanel panel;
	private String location;
	private List<EntryPoint> entryPoints;
	private List<ExitPoint> exitPoints;
	Map<String, ParkingFloor> map;

	public ParkingLot(String location) {
		super();
		this.location = location;
		map = new HashMap<String, ParkingFloor>();
		parkingFloors = new ArrayList<ParkingFloor>();
	}

	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}
	public void addParkingFloor(ParkingFloor parkingFloor) throws ParkingFloorNameDuplicateException {
		if(map.containsKey(parkingFloor.getFloorIdentifier())) {
			throw new ParkingFloorNameDuplicateException("Same Parking Floor Name Exist");
		}
		else {
			map.put(parkingFloor.getFloorIdentifier(), parkingFloor);
			parkingFloors.add(parkingFloor);
		}
	}
	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public EntrancePanel getPanel() {
		return panel;
	}

	public void setPanel(EntrancePanel panel) {
		this.panel = panel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<EntryPoint> getEntryPoints() {
		return entryPoints;
	}

	public void setEntryPoints(List<EntryPoint> entryPoints) {
		this.entryPoints = entryPoints;
	}

	public List<ExitPoint> getExitPoints() {
		return exitPoints;
	}

	public void setExitPoints(List<ExitPoint> exitPoints) {
		this.exitPoints = exitPoints;
	}

	public Map<String, ParkingFloor> getMap() {
		return map;
	}

	public void setMap(Map<String, ParkingFloor> map) {
		this.map = map;
	}

	
}
