package business;

import java.util.ArrayList;

import model.User;

public class validateUser {
  User newUser = new User();
	ArrayList<String> errors = new ArrayList<String>();
	checkString check = new checkString();
	checkStringSpace check2 = new checkStringSpace();
	checkNumeric check3 = new checkNumeric();
	public User validUser(String first, String last, String email, String confirmEmail, String phone, String workPhone, String password, 
			String confirmPass, String emerContact, String emerPhone, String postal,String address )
	{
		if(check3.check(phone) == false)
        {
			errors.add("Invalid phone # entered.");
        }
		if(check3.check(workPhone) == false)
        {
			errors.add("Invalid work phone # entered.");
        }
		else
		{
			newUser.setHomePhone(phone);
		}
		if(check3.check(emerPhone) == false)
		{
			errors.add("Invalid emergency phone # entered.");
		}
		else
		{
			newUser.setEmerPhone(emerPhone);
		}
		if(!password.matches("^[0-9a-zA-Z]+$") || !confirmPass.equals(password))
		{
			errors.add("Invalid password entered.");
		}
		else
		{
			newUser.setPassword(password);
		}
		if(!postal.matches("^[0-9a-zA-Z ]+$"))
		{
			errors.add("Invalid postal code entered.");
		}
		else
		{
			newUser.setPostal(postal);
		}
       // ValidationUtils.invokeValidator(this.validateUser, obj, e);
        if(!address.matches("^[0-9a-zA-Z ]+$"))
        {
        	errors.add("Invalid address entered.");
        }
        else
        {
        	newUser.setAddress(address);
        }
        if(!email.matches(".+@.+..+") || !confirmEmail.equals(email))
        {
        	errors.add("Invalid email address entered.");
        }
        else
        {
        	newUser.setEmail(email);
        }
        if(check.check(first) == false)
        {
        	errors.add("Invalid first name entered.");
        }
        else
        {
        	newUser.setFirst(first);
        }
        if(check.check(last) == false)
        {
        	errors.add("Invalid last name entered.");
        }
        else
        {
        	newUser.setLast(last);
        }
      
        if(check2.check(emerContact) == false)
        {
        	errors.add("Invalid emergency contact entered.");
        }
        else
        {
        	newUser.setEmerContact(emerContact);
        }
        newUser.setErrors(errors);
        return newUser;
}
	
	}
 
