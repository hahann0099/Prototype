package business;

import data_access.*;
import model.*;

public class manageTeacher {
  int teacherID;
	int valid=0;
	
	Access dataAccess = new Access();
	Insert newInsert = new Insert();
	Retrieval retrieve = new Retrieval();
	
	public int validate(Entity entity)
	{
		teacherID = dataAccess.LogUser(entity, "authenticate");
		return teacherID;
	}
	public int createTeacher(Entity entity)
	{
		valid = newInsert.createTeacher(entity);
		return valid;
	}
	
}
