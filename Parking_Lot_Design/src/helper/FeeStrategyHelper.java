package helper;

import constants.ServiceType;
import service.ElectricChargeFeeStrategy;
import service.IFeeStrategy;
import service.ParkingFeeStrategy;

public class FeeStrategyHelper {
	public static IFeeStrategy getFeeStrategy(ServiceType type) throws Exception {
		if(type.equals(ServiceType.PARK)) {
			return new ParkingFeeStrategy();
		}
		else if(type.equals(ServiceType.EV_CHARGE)) {
			return new ElectricChargeFeeStrategy();
		}
		throw new Exception("Invalid Service Type");
	}
}
