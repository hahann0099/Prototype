package model;

import java.util.ArrayList;

public class Student {
	String first;
	String last;
	int age;
	ArrayList<Course> classes;
	String gender;
	String danceExp;
	String cardNo;
	String healthCon;
	int studentID;
	int userID;
	ArrayList<String> errors = new ArrayList<String>();
	java.sql.Date DOB = new java.sql.Date(age);

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public java.sql.Date getDOB() {
		return DOB;
	}

	public void setDOB(java.sql.Date dOB) {
		DOB = dOB;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Course> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Course> classes) {
		this.classes = classes;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDanceExp() {
		return danceExp;
	}

	public void setDanceExp(String danceExp) {
		this.danceExp = danceExp;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getHealthCon() {
		return healthCon;
	}

	public void setHealthCon(String healthCon) {
		this.healthCon = healthCon;
	}

}
