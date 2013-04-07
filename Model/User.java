package model;

import java.util.ArrayList;

public class User {
String username;
String password;
String email;
String first;
String last;
String Address;
String province;
String homePhone;
String city; 
String emerContact;
String postal;
String emerPhone;
String workPhone;
int userID;
ArrayList<Invoice> invoices = new ArrayList<Invoice>();
ArrayList<Invoice> paidInvoices = new ArrayList<Invoice>();
ArrayList<String> errors = new ArrayList<String>();

public ArrayList<String> getErrors() {
	return errors;
}
public void setErrors(ArrayList<String> errors) {
	this.errors = errors;
}
public ArrayList<Invoice> getPaidInvoices() {
	return paidInvoices;
}
public void setPaidInvoices(ArrayList<Invoice> paidInvoices) {
	this.paidInvoices = paidInvoices;
}
public ArrayList<Invoice> getInvoices() {
	return invoices;
}
public void setInvoices(ArrayList<Invoice> invoices) {
	this.invoices = invoices;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getPostal() {
	return postal;
}
public void setPostal(String postal) {
	this.postal = postal;
}
public String getEmerContact() {
	return emerContact;
}
public void setEmerContact(String emerContact) {
	this.emerContact = emerContact;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
ArrayList<Student> students;
public String getAddress() {
	return Address;
}
public ArrayList<Student> getStudents() {
	return students;
}
public void setStudents(ArrayList<Student> students) {
	this.students = students;
}
public void setAddress(String address) {
	Address = address;
}
public String getHomePhone() {
	return homePhone;
}
public void setHomePhone(String homePhone) {
	this.homePhone = homePhone;
}
public String getEmerPhone() {
	return emerPhone;
}
public void setEmerPhone(String emerPhone) {
	this.emerPhone = emerPhone;
}
public String getWorkPhone() {
	return workPhone;
}
public void setWorkPhone(String workPhone) {
	this.workPhone = workPhone;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}

}
