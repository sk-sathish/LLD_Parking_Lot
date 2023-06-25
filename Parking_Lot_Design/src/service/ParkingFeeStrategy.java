package service;

public class ParkingFeeStrategy implements IFeeStrategy{

	@Override
	public double calculateFee(double minutes) {
		// TODO Auto-generated method stub
		if(minutes<=60) {
			return 4.5d;
		}
		else if(minutes<=120) {
			return 7.5d;
		}
		else if(minutes<=180) {
			return 11d;
		}
		else {
			return 11+2.5*(Math.ceil((minutes-180)/60));
		}
	}

}
