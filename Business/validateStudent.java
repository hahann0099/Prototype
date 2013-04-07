package business;

import java.util.ArrayList;

import model.Student;

public class validateStudent {
  checkString check1 = new checkString();
	checkStringSpace check2 = new checkStringSpace();
	checkStringSpaceNum check3 = new checkStringSpaceNum();
	checkNumeric check4 = new checkNumeric();
	Student tempStudent = new Student();
	ArrayList<String> errors = new ArrayList<String>();
public Student validate(String first, String last, String danceExp, String card, String healthCon)
{
if(check1.check(first) == false)
{
	errors.add("Invalid first name entered.");
}
else
{
	tempStudent.setFirst(first);
}
if(check1.check(last) == false)
{
	errors.add("Invalid last name entered.");
}
else
{
	tempStudent.setLast(last);
}
if(check3.check(healthCon) == false)
{
	errors.add("Invalid health concerns entered.");
}
else
{
	tempStudent.setHealthCon(healthCon);
}
if(check3.check(danceExp) == false)
{
	errors.add("Invalid dance experience entered.");
}
else
{
	tempStudent.setDanceExp(danceExp);
}
if(check4.check(card) == false)
{
	errors.add("Invalid health card # entered.");
}
else
{
	tempStudent.setCardNo(card);
}
tempStudent.setErrors(errors);
return tempStudent;
}
}
