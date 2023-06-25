package service;

public class ElectricChargeFeeStrategy implements IFeeStrategy{

	@Override
	public double calculateFee(double minutes) {
		// TODO Auto-generated method stub
		return minutes*0.5d;
	}

}
