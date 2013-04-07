package model;

import java.util.ArrayList;

public class Payment {
String first;
String last;
int code;
double subtotal;
double total;
java.sql.Date expiry;
String cardNo;
String cardType;
String postal;
String address;
String province;
String city;
int paymentID;
int userID;
double tax;
ArrayList <String> errors = new ArrayList<String>();

public ArrayList<String> getErrors() {
	return errors;
}
public void setErrors(ArrayList<String> errors) {
	this.errors = errors;
}
public String getPostal() {
	return postal;
}
public void setPostal(String postal) {
	this.postal = postal;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
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
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public java.sql.Date getExpiry() {
	return expiry;
}
public void setExpiry(java.sql.Date expiry) {
	this.expiry = expiry;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public String getCardType() {
	return cardType;
}
public void setCardType(String cardType) {
	this.cardType = cardType;
}
public int getPaymentID() {
	return paymentID;
}
public void setPaymentID(int paymentID) {
	this.paymentID = paymentID;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public double getTax() {
	return tax;
}
public void setTax(double tax) {
	this.tax = tax;
}

}
