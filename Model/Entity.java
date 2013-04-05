package model;

public class Entity {
User user = new User();
Student student = new Student();
Teacher teacher = new Teacher();
Course course = new Course();
Retrieval retrieval = new Retrieval();
Payment payment = new Payment();
Invoice invoice = new Invoice();

public Invoice getInvoice() {
	return invoice;
}
public void setInvoice(Invoice invoice) {
	this.invoice = invoice;
}
public Retrieval getRetrieval() {
	return retrieval;
}
public Payment getPayment() {
	return payment;
}
public void setPayment(Payment payment) {
	this.payment = payment;
}
public void setRetrieval(Retrieval retrieval) {
	this.retrieval = retrieval;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public Teacher getTeacher() {
	return teacher;
}
public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
}
