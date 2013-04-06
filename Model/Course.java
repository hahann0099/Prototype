package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Course {
String name;
int year = Calendar.getInstance().YEAR;
int month = Calendar.getInstance().MONTH;
int day = Calendar.getInstance().DAY_OF_MONTH;
java.sql.Date date = new java.sql.Date(year, month, day);
String term;
int start;
int end;
double price;
public Teacher teacher;
int classID;
ArrayList students;
public java.sql.Date getDate() {
	return date;
}
public void setDate(java.sql.Date date) {
	this.date = date;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getclassID() {
	return classID;
}
public void setclassID(int courseID) {
	this.classID = courseID;
}

public ArrayList getStudents() {
	return students;
}
public void setStudents(ArrayList students) {
	this.students = students;
}

public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTerm() {
	return term;
}
public void setTerm(String term) {
	this.term = term;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public int getEnd() {
	return end;
}
public void setEnd(int end) {
	this.end = end;
}
public void reverseDate(){
	year = date.getYear();
	month = date.getMonth();
	day = date.getDay();
}
}
