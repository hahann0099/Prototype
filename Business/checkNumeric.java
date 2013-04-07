package business;

public class checkNumeric {
public boolean check (String enter)
{
  if (enter.matches("^(0|[1-9][0-9]*)$"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
}
