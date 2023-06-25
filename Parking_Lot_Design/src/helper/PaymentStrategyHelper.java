package helper;

import constants.PaymentType;
import service.CashPayment;
import service.CreditCardPayment;
import service.IPaymentStrategy;

public class PaymentStrategyHelper {
	public static IPaymentStrategy getPaymentStrategy(PaymentType type) throws Exception {
		if(type.equals(PaymentType.CASH)) {
			return new CashPayment();
		}
		else if(type.equals(PaymentType.CREDIT_CARD)) {
			return new CreditCardPayment();
		}
		throw new Exception("Invalid Payment Type");
	}
}
