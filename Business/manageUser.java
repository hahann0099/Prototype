package business;

import java.util.ArrayList;

import data_access.Access;
import data_access.Insert;
import model.Course;
import model.Entity;
import model.Retrieval;
import model.Student;
import model.User;

public class manageUser {
	int userID;
	int valid=0;
	Access dataAccess = new Access();
	Insert newInsert = new Insert();
	Retrieval retrieve = new Retrieval();
		ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Student> studentInfo = new ArrayList<Student>();
	ArrayList<Student> studentInfos = new ArrayList<Student>();
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Course> courseInfo = new ArrayList<Course>();

public int validate(Entity entity)
{
	userID = dataAccess.LogUser(entity, "authenticate");
	return userID;
}
public int createUser(Entity entity)
{
	valid = newInsert.createUser(entity);
	return valid;
}
public Entity UserInfo(Entity entity)
{
	entity = dataAccess.userInfo(entity);
	return entity;
}
public Entity acquireInfo (Entity entity)
{
	
	entity = dataAccess.queryStudents(entity, "userStudents");
		courses = dataAccess.queryCourses(entity, "allCourses");
	retrieve.setCourses(courses);
		
		entity.setRetrieval(retrieve);
		return entity;
}
public ArrayList<Student> retrieveStudents(Entity entity)
{
	students = new ArrayList();
	entity.getUser().setStudents(students);
	entity = dataAccess.queryStudents(entity, "userStudents");
	studentInfo = entity.getUser().getStudents();
	return studentInfo;
}
}
