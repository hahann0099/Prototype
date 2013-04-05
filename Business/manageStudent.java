package business;

import data_access.Access;
import data_access.Insert;
import model.Entity;

public class manageStudent {
	int success;
	Access dataAccess = new Access();
	Insert newInsert = new Insert();
public int addStudent(Entity entity)
{
	success = newInsert.insertStudent(entity);
	return success;
}
}
