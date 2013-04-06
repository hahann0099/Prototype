package data_access;

import javax.sql.DataSource;

import model.Entity;
import model.Invoice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Insert {
	DataSource source = getDataSource();
	JdbcTemplate template = new JdbcTemplate(source);
	int success = 0;
	Invoice inv = new Invoice();
	private static DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/studio");
		dataSource.setUsername("root");
		dataSource.setPassword("lolcakes");
		return dataSource;
	}
public int insertPayment (Entity entity)
{
	success = 0;
	success = this.template.update("insert into payment (userID, cardType, cardNo, First, Last, Code, Expiry, Subtotal, Tax, Total, Address, Postal, City, Province)" +
			" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]
			{entity.getUser().getUserID(), entity.getPayment().getCardType(),
			entity.getPayment().getCardNo(), entity.getPayment().getFirst(), entity.getPayment().getLast(),
			entity.getPayment().getCode(),entity.getPayment().getExpiry(), entity.getPayment().getSubtotal(), 
			entity.getPayment().getTax(), entity.getPayment().getTotal(), 
			entity.getPayment().getAddress(), entity.getPayment().getPostal(), entity.getPayment().getCity(),
			entity.getPayment().getProvince()});
	return success;
}
public int createUser (Entity entity)
{
	success = this.template.update("insert into user (First, Last, Email, Password, Address,Postal, City, homePhone, Province, emerContact, emerPhone) values (?,?,?,?,?,?,?,?,?,?,?)", new Object[]
			{entity.getUser().getFirst(), entity.getUser().getLast(),
			entity.getUser().getEmail(), entity.getUser().getPassword(), entity.getUser().getAddress(),
			entity.getUser().getPostal(),entity.getUser().getCity(), entity.getUser().getHomePhone(), 
			entity.getUser().getProvince(), entity.getUser().getEmerContact(), 
			entity.getUser().getEmerPhone()});
	return success;
}
public int insertStudent(Entity entity)
{
	success = this.template.update("INSERT INTO student (classID, First, Last, Age, Gender, healthCon, danceExp, DOB, cardNo, userID) VALUES (?,?,?,?,?,?,?,?,?,?)",
		new Object[]
			{4, entity.getStudent().getFirst(),
			entity.getStudent().getLast(), entity.getStudent().getAge(), entity.getStudent().getGender(),
			entity.getStudent().getHealthCon(), entity.getStudent().getDanceExp(),
			entity.getStudent().getDOB(), entity.getStudent().getCardNo(), entity.getUser().getUserID()}); 
	return success;
}
public int insertInvoice(Entity entity)
{
	success = this.template.update("insert into invoice (userID, First, Last, address, Subtotal, Tax, Total, Province, City ) values (?,?,?,?,?,?,?,?,?)", new Object[]
			{entity.getUser().getUserID(), entity.getInvoice().getFirst(), 
			entity.getInvoice().getLast(), entity.getUser().getAddress(),
			entity.getInvoice().getSubtotal(), entity.getInvoice().getTax(), 
			entity.getInvoice().getTotal(), entity.getInvoice().getProvince(), 
			entity.getInvoice().getCity()});
	return success;
}
public int createTeacher (Entity entity)
{
	success = this.template.update("insert into teacher (First, Last) values (?,?)", new Object[]
			{entity.getTeacher().getFirst(),
			entity.getTeacher().getLast()});
	return success;
}
public int createCourse (Entity entity)
{
	success = this.template.update("insert into course (teacherID, Name, Date, Term, Start, End, Price) values (?,?,?,?,?,?,?)", new Object[]
			{entity.getCourse().teacher.getTeacherID(),
			entity.getCourse().getName(),
			entity.getCourse().getDate(),
			entity.getCourse().getTerm(),
			entity.getCourse().getStart(),
			entity.getCourse().getEnd(),
			entity.getCourse().getPrice()});
	return success;
}
}
