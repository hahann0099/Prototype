package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Course;
import model.Entity;
import model.Invoice;
import model.Student;
import model.Teacher;
import model.User;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.*;

public class Access {

	int success = 0;
	int teacherID = 1;
	ArrayList data = new ArrayList();
	ArrayList classes = new ArrayList();
	ArrayList<Student> students = new ArrayList();
	Teacher teacher = new Teacher();
	Boolean valid = false;
	Connection conn;
	String sql;
	int userID;
	Entity newEntity = new Entity();
	User newUser = new User();
	DataSource source = getDataSource();
	JdbcTemplate template = new JdbcTemplate(source);

	protected void connect() {
		// Define driver, connection URL, username, and password
		String driverName = "com.mysql.jdbc.Driver";
		String conURL = "jdbc:mysql://localhost:3306/studio";
		String user = "root";
		String pass = "lolcakes";
		try {
			// Instantiate a new instance of the driver
			Class.forName(driverName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// Get the connection from the Driver
			conn = DriverManager.getConnection(conURL, user, pass);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Entity pullCourseInfo(Entity entity)
	{
		String sqlClass = "SELECT * FROM class WHERE classID= ?";
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Course course = (Course) template.queryForObject(sqlClass,
						new Object[] { entity.getCourse().getclassID() },
						new BeanPropertyRowMapper(Course.class));
				course.setclassID(entity.getCourse().getclassID());
				entity.setCourse(course);
				return entity;
	}
		/*Added: 05/04/13 
	 * Gets the student's class and assigns it to an array
	 */
	public ArrayList<Course> queryCourse(int studentID) {
		
			ArrayList<Course> wipe = new ArrayList();
			ArrayList<Course> classID = new ArrayList();
			String sql = "SELECT classID FROM student WHERE studentID = "
					+ studentID;
			List<Map<String, Object>> rows = template.queryForList(sql);
			for (Map row : rows) {
				Course newClassID = new Course();
				newClassID.setclassID((Integer)row.get("classID"));
				classID.add(newClassID);
			}
			
			for (Course id:classID ) {
				String sql2 = "SELECT * FROM class WHERE classID= ?";
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Course newClass = (Course) template.queryForObject(sql2,
						new Object[] { id.getclassID() },
						new BeanPropertyRowMapper(Course.class));
				wipe.add(newClass);
			}
			
	
		return wipe;
	}
	
	public ArrayList<Course> queryCourses(Entity entity, String keyword) {
		ArrayList<Course> courses = new ArrayList();
		if (keyword.equals("allCourses")) {
			
			String sql = "SELECT * FROM class";
			List<Map<String, Object>> rows = template.queryForList(sql);
			for (Map row : rows) {
				Course course = new Course();
				course.setclassID((Integer) row.get("classID"));
				course.setDate((Date) (row.get("Date")));
				course.setStart((Integer)row.get("Start"));
				course.setEnd((Integer) row.get("End"));
				course.setName(row.get("Name").toString());
				course.setTerm(row.get("Term").toString());
				course.setPrice(Double.parseDouble(row.get("Price").toString()));
				teacher.setTeacherID((Integer) row.get("teacherID"));
				course.setTeacher(teacher);
				courses.add(course);
			}

		}
		return courses;
	}
	/*Added: 04/04/13 
	 * Pulls invoices from the database to display already paid  
	 * paid invoices to the user.
	 */
	public ArrayList<Invoice> pullInvoices(Entity entity)
	{
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		String sql = "SELECT * FROM invoice WHERE userID = "
					+ entity.getUser().getUserID() + " AND isPaid = 1;";
			List<Map<String, Object>> rows = template.queryForList(sql);
			for (Map row : rows) {
				Invoice invoice = new Invoice();
				invoice.setInvoiceID(((Integer) row.get("invoiceID")));
				invoice.setAddress(row.get("Address").toString());
				invoice.setCity(row.get("City").toString());
				invoice.setProvince(row.get("Province").toString());
				invoice.setFirst(row.get("First").toString());
				invoice.setLast(row.get("Last").toString());
				invoice.setCardNo(row.get("cardNo").toString());
				invoice.setCardType(row.get("cardType").toString());
				invoice.setCode((Integer)row.get("code")); //Added: 05/04/13 grabs the card code
				invoice.setSubtotal((Double) row.get("Subtotal"));
				invoice.setTax((Double) row.get("Tax"));
				invoice.setTotal((Double)row.get("Total"));
				invoices.add(invoice);
			}
			return invoices;
	}
	
	public Entity queryStudents(Entity entity, String keyword) {
		if (keyword.equals("userStudents")) {
			ArrayList<Student> wipe = new ArrayList();
			ArrayList<Student> studentID = new ArrayList();
			String sql = "SELECT studentID FROM student WHERE userID = "
					+ entity.getUser().getUserID();
			List<Map<String, Object>> rows = template.queryForList(sql);
			for (Map row : rows) {
				Student student = new Student();
				student.setStudentID((Integer) row.get("studentID"));
				studentID.add(student);
			}
			
			for (Student member : studentID) {
				String sql2 = "SELECT * FROM student WHERE studentID= ?";
				@SuppressWarnings({ "unchecked", "rawtypes" })
				Student person = (Student) template.queryForObject(sql2,
						new Object[] { member.getStudentID() },
						new BeanPropertyRowMapper(Student.class));
				wipe.add(person);
			}
			entity.getUser().setStudents(wipe);
		}
		return entity;

	}

	private static DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/studio");
		dataSource.setUsername("root");
		dataSource.setPassword("lolcakes");
		return dataSource;
	}
	
	public int LogUser(Entity entity, String keyword) {
		connect();
		PreparedStatement query = null;
		try {
			sql = "select userID from user where email = ? AND password=?";
			query = conn.prepareStatement(sql);
			query.setString(1, entity.getUser().getEmail());
			query.setString(2, entity.getUser().getPassword());

			ResultSet rs = query.executeQuery();

			while (rs.next()) {

				userID = rs.getInt("userID");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userID;
	}

	public ArrayList query(Entity entity, String keyword) {
		connect();
		PreparedStatement query = null;
		ResultSet rs = null;
		try {

			if (keyword.equals("authenticate")) {
				sql = "select username, password from user where username = ? AND password=?";
				query = conn.prepareStatement(sql);
				query.setString(1, entity.getUser().getUsername());
				query.setString(2, entity.getUser().getPassword());

				rs = query.executeQuery();
				valid = rs.next();
				data.add(valid);
			}
			if (keyword.equals("classTeacher") || keyword.equals("stuTeacher")) {

				if (keyword.equals("stuTeacher")) {

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	public Entity userInfo(Entity entity)
	{
			String sqlUser = "SELECT * FROM user WHERE userID= ?";
		User regUser = (User) template.queryForObject(sqlUser,
						new Object[] { entity.getUser().getUserID()},
						new BeanPropertyRowMapper(User.class));
		regUser.setUserID(entity.getUser().getUserID());
		entity.setUser(regUser);
		return entity;
	}
	public ArrayList<Invoice> queryInvoices(Entity entity)
	{
	 	ArrayList<Invoice> invoices = new ArrayList();
			
			String sql = "SELECT * from invoice where userID = "
					+ entity.getUser().getUserID();
			List<Map<String, Object>> rows = template.queryForList(sql);
			for (Map row : rows) {
				Invoice invoice = new Invoice();
				invoice.setAddress((String)row.get("address"));
				invoice.setFirst((String)row.get("first"));
				invoice.setLast((String)row.get("last"));
				invoice.setCity((String)row.get("city"));
				invoice.setInvoiceID((int)row.get("invoiceID"));
				invoice.setProvince((String)row.get("province"));
				invoice.setSubtotal((Double)row.get("subtotal"));
				invoice.setTax((Double)row.get("tax"));
				invoice.setTotal((Double)row.get("total"));
				invoices.add(invoice);
				}
			return invoices;
	}
	public Teacher getTeacher(String id){
		PreparedStatement query = null;
		Teacher teacher = new Teacher();
		String sql = "SELECT * from teacher WHERE teacherID = ?";
		try{
			query.setString(1, id);
			query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();
			teacher.setTeacherID(rs.getInt("teacherID"));
			teacher.setFirst(rs.getString("First"));
			teacher.setLast("Last");
		}
		catch (SQLException e) {
		e.printStackTrace();
		}


		return teacher;
	}
		public ArrayList<Course> getAllCourse()
	{
		ArrayList<Course> courses = new ArrayList();
		
		String sql = "SELECT * from course";
		List<Map<String, Object>> rows = template.queryForList(sql);
		for (Map row: rows){
			Course course = new Course();
			course.setclassID((int)row.get("classID"));
			course.setDate((Date)row.get("Date"));
			course.setName((String)row.get("Name"));
			course.setTerm((String)row.get("Term"));
			course.setPrice((double)row.get("Price"));
			course.setTeacher(getTeacher((String)row.get("teacherID")));
			course.setStart((int)row.get("Start"));
		}
		return courses;
	}
}
