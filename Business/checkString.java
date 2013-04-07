package business;

public class checkString {
public boolean check(String string)
{
  if (string.matches("[a-zA-Z]*"))
	{
	return true;
	}
	else
	{
		return false;
	}
}
}
