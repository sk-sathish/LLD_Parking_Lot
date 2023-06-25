package service;

public class CreditCardPayment implements IPaymentStrategy{

	@Override
	public void makePayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Credit Card payment recorded");
	}

}
