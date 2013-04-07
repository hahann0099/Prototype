package business;

public class checkStringSpace {
public boolean check(String enter)
{
  if (enter.matches("[a-zA-Z ]*"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
}
