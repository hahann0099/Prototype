package model;

import java.util.ArrayList;

public class Retrieval {
ArrayList <Course> courses;
ArrayList <Student> students;
ArrayList <User> users;
ArrayList <Teacher> teachers;

public ArrayList<Teacher> getTeachers() {
	return teachers;
}

public void setTeachers(ArrayList<Teacher> teachers) {
	this.teachers = teachers;
}

public ArrayList<User> getUsers() {
	return users;
}

public void setUsers(ArrayList<User> users) {
	this.users = users;
}

public ArrayList<Course> getCourses() {
	return courses;
}

public void setCourses(ArrayList<Course> courses) {
	this.courses = courses;
}

public ArrayList<Student> getStudents() {
	return students;
}

public void setStudents(ArrayList<Student> students) {
	this.students = students;
}

}
