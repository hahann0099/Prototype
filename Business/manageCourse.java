package business;

import data_access.Access;
import model.Entity;

public class manageCourse {
Access dataAccess = new Access();
	public Entity courseInfo(Entity entity)
	{
		entity = dataAccess.pullCourseInfo(entity);
		return entity;
	}
}
