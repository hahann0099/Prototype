package business;

public class checkStringSpaceNum {
public Boolean check (String enter)
{
  if (enter.matches("^[0-9a-zA-Z ]+$"))
			{
		return true;
			}
	else
	{
		return false;
	}
}

}
