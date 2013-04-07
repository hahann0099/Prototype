package business;

import java.util.ArrayList;

import model.Payment;
import model.User;

public class validatePayment {
Payment tempPayment = new Payment();
//  StringToInteger convert = new StringToInteger();
	ArrayList<String> errors = new ArrayList<String>();
	checkString check = new checkString();
	checkStringSpace check2 = new checkStringSpace();
	checkNumeric check3 = new checkNumeric();
public Payment validate(String first, String last, String address, String postal, String cardNo, String code)
{
	if(check.check(first) == false)
	{
		errors.add("Invalid first name entered.");
	}
	else
	{
		tempPayment.setFirst(first);
	}
	if(check.check(last) == false)
	{
		errors.add("Invalid last name entered.");
	}
	else
	{
		tempPayment.setLast(last);
	}
	if(!address.matches("^[0-9a-zA-Z ]+$"))
	{
		errors.add("Invalid address entered.");
	}
	else
	{
		tempPayment.setAddress(address);
	}
	if(!postal.matches("^[0-9a-zA-Z ]+$"))
	{
		errors.add("Invalid postal code entered.");
	}
	else
	{
		tempPayment.setPostal(postal);
	}
	if(!check3.check(cardNo) == false)
	{
		errors.add("Invalid card number entered.");
	}
	else
	{
		tempPayment.setCardNo(cardNo);
	}
	try
	{
	tempPayment.setCode(Integer.parseInt(code));
	 } catch(NumberFormatException e) { 
        errors.add("Invalid security code entered.");
	 }
	tempPayment.setErrors(errors);
	return tempPayment;
	
}
}
