package business;

import java.util.ArrayList;

import data_access.Access;
import data_access.Insert;
import data_access.Update;
import model.Entity;
import model.Course;

public class manageStudent {
	int success;
	Access dataAccess = new Access();
	Insert newInsert = new Insert();
	Update newUpdate = new Update();
	ArrayList <Course> studCourses = new ArrayList<Course>();
public int addStudent(Entity entity)
{
	success = newInsert.insertStudent(entity);
	return success;
}
public int updateStudent (Entity entity)
{
	success = 0;
	success =newUpdate.updateStudent(entity, "enroll");
	return success;
}
/* 
 * Added 05/04/13
 * Gets the student's class and adds it to an array
 * */
public ArrayList <Course> retrieveStudClass (int studentID)
{
	studCourses = dataAccess.queryCourse(studentID);
	return studCourses;
}
}
