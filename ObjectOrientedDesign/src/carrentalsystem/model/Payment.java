package carrentalsystem.model;

import java.util.Date;

public class Payment {

	Date date;
	double amount;
	PaymentStatus status;
}

class CreditCardTransaction extends Payment{
	
	String nameOnCard;
	
}
class CheckTransaction extends Payment{
	
	String bankName;
	int ChequeNumber;
}

class CashTransaction extends Payment{
	double cashTendered;
}