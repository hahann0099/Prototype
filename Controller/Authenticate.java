package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import business.manageCourse;
import business.managePayment;
import business.manageStudent;
import business.manageTeacher;
import business.manageUser;

import data_access.Access;
import data_access.Update;
import model.Course;
import model.Entity;
import model.Invoice;
import model.Payment;
import model.Student;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Entity entity = new Entity();
	ArrayList data;
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Student> studentInfo = new ArrayList<Student>();
	ArrayList<Student> studentInfos = new ArrayList<Student>();
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	ArrayList<Invoice> pInvoices = new ArrayList<Invoice>();
	int success = 0;
	int invoice = 0;
	int userID;
	Boolean created = false;
	String[] firstLast = new String[4];
	String[] monthdayyear = new String[5];
	String message = "Student class addition failed.";
	String registered = "Registration Unsuccessful.";
	SimpleDateFormat parse = new SimpleDateFormat("yyyy-mm-dd");
	Date currentDate = new Date();
	Invoice test = new Invoice();
	User newUser = new User();
	Access dataAccess = new Access();
	Update newUpdate = new Update();
	Student student = new Student();
	Course course = new Course();
	Payment newPayment = new Payment();
	manageUser userm = new manageUser();
	manageTeacher teachm = new manageTeacher();
	manageStudent studm = new manageStudent();
	manageCourse coursem = new manageCourse();
	managePayment paym = new managePayment();
	private static final Logger logger = Logger.getLogger(Authenticate.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authenticate() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void validUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// ValidationUtils.rejectIfEmpty(er, request.getParameter("username"),
		// "name.empty");
		HttpSession newSession = request.getSession();
		PrintWriter out = response.getWriter();
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));

		entity.setUser(newUser);
		userID = userm.validate(entity);
		entity = userm.acquireInfo(entity);
		out.println(entity.getUser().getUserID());
		student.setUserID(entity.getUser().getUserID());
		newUser.setUserID(userID);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/manageAccount.html");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession newSession = request.getSession();
		newUser.setFirst(request.getParameter("first"));
		newUser.setLast(request.getParameter("last"));
		newUser.setAddress(request.getParameter("address"));
		newUser.setCity(request.getParameter("city"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setEmerPhone(request.getParameter("emerP"));
		newUser.setHomePhone(request.getParameter("phone"));
		newUser.setProvince(request.getParameter("province"));
		newUser.setPassword(request.getParameter("pass"));
		newUser.setEmerContact(request.getParameter("emer"));
		newUser.setPostal(request.getParameter("postal"));
		entity.setUser(newUser);
		success = userm.createUser(entity);
		if (success > 0) {
			registered = "Account Successfully Created! Please Login.";
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/userLogin.html");
		dispatcher.forward(request, response);
		newSession.setAttribute("Registered", registered);
	}
	public void payInvoice(HttpServletRequest request,
			HttpServletResponse response)
	{
		int id = entity.getInvoice().getInvoiceID();
		
	}
	public void selectStu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession newSession = request.getSession();
		PrintWriter out = response.getWriter();
		entity = userm.acquireInfo(entity);
		int id = Integer.parseInt(request.getParameter("Student"));
		for (Student stude : entity.getUser().getStudents()) {
			if (stude.getStudentID() == id) {
				studentInfos.add(stude);
			}
		}
		newSession.setAttribute("studentInfos", studentInfos);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/viewStudent.jsp");
		dispatcher.forward(request, response);

	}

	public void pullInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession newSession = request.getSession();
		entity = userm.acquireInfo(entity);

		newSession.setAttribute("students", entity.getUser().getStudents());
		newSession.setAttribute("courses", entity.getRetrieval().getCourses());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/assignClass.jsp");
		dispatcher.forward(request, response);

	}

	public void assignClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession newSession = request.getSession();
		PrintWriter out = response.getWriter();
		int courseInt = Integer.parseInt(request.getParameter("Classes"));
		int studentInt = Integer.parseInt(request.getParameter("Students"));
		entity.getCourse().setclassID(courseInt);
		entity.getStudent().setStudentID(studentInt);
		entity = userm.UserInfo(entity);
		entity = coursem.courseInfo(entity);
		success = newUpdate.updateStudent(entity, "enroll");
		if (success > 0) {
			message = "Student successfully added to the class!";
			if (invoice > 0) {
				message = "Student successfully added to the class! Invoice Generated.";
			}
		}
		invoice = paym.createInvoice(entity);
		newSession.setAttribute("message", message);
		studentView(request, response);
	}

	public void studentView(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession newSession = request.getSession();
		PrintWriter out = response.getWriter();
		userID = userm.validate(entity);
		student.setUserID(userID);
		entity.setStudent(student);
		studentInfo.clear();
		studentInfo = userm.retrieveStudents(entity);
		entity = paym.retrieveInvoices(entity);
		
		invoices = entity.getUser().getInvoices();
		
		newSession.setAttribute("studentInfo", studentInfo);
		newSession.setAttribute("invoices", invoices);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/viewStudent.jsp");
		dispatcher.forward(request, response);

	}
	public void processPayment(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, ServletException, IOException
	{
		String expiry = request.getParameter("expiry");
		monthdayyear = expiry.toString().split("-");
		@SuppressWarnings("deprecation")
		java.sql.Date cexpiry = new java.sql.Date(Integer.parseInt(monthdayyear[2]
				.toString()), Integer.parseInt(monthdayyear[1].toString()),
				Integer.parseInt(monthdayyear[0].toString()));
	newPayment.setCardNo(request.getParameter("cardNo"));
		newPayment.setCardNo(request.getParameter("cardNo"));
			newPayment.setProvince(request.getParameter("province"));
		newPayment.setSubtotal(entity.getInvoice().getSubtotal());
		newPayment.setTax(entity.getInvoice().getTax());
		newPayment.setTotal(entity.getInvoice().getTotal());
		newPayment.setFirst(request.getParameter("first"));
		newPayment.setLast(request.getParameter("last"));
		newPayment.setAddress(request.getParameter("address"));
		newPayment.setPostal(request.getParameter("postal"));
		newPayment.setCity(request.getParameter("city"));
		newPayment.setCode(Integer.parseInt(request.getParameter("code")));
		newPayment.setCardType(request.getParameter("cardType"));
		newPayment.setExpiry(cexpiry);
		entity.setPayment(newPayment);
		success = paym.processPayment(entity); //Added: 05/04/13 Inserts a payment into the payment table, if its successful, continues
		paym.payInvoice(entity.getInvoice().getInvoiceID());
		if (success > 0)
		{
			message = "Payment Received!";
			request.setAttribute("message", message);
			
		}
		else
		{
			message = "Payment failed";
		}
		invoices = entity.getUser().getInvoices();
		pInvoices = paym.paidInv(entity); //Added: 04/04/13 calls the method to pull paid invoices from the database

		entity.getUser().setPaidInvoices(pInvoices); //Added: 05/04/13 Sets the paid invoices for later use
		request.setAttribute("invoices", invoices);
		request.setAttribute("pInvoices", pInvoices); //Added: 04/04/13, sets an attribute of the paid invoices to show them in the jsp
			RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Invoices.jsp");
		dispatcher.forward(request, response);
	}
	public void addStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			ParseException {

		PrintWriter out = response.getWriter();
		String name = request.getParameter("Name");
		String dob = request.getParameter("DOB");

		firstLast = name.toString().split(" ");
		monthdayyear = dob.toString().split("-");
		@SuppressWarnings("deprecation")
		java.sql.Date date = new java.sql.Date(Integer.parseInt(monthdayyear[2]
				.toString()), Integer.parseInt(monthdayyear[1].toString()),
				Integer.parseInt(monthdayyear[0].toString()));
		student.setFirst(firstLast[0]);
		student.setLast(firstLast[1]);

		student.setAge(Calendar.getInstance().get(Calendar.YEAR)
				- Integer.parseInt(monthdayyear[2]));
		student.setDOB(date);
		student.setDanceExp(request.getParameter("danceExp"));
		student.setHealthCon(request.getParameter("healthCon"));
		student.setCardNo(request.getParameter("card"));
		if (request.getParameter("sex").equals("male")) {
			student.setGender("M");
		} else if (request.getParameter("sex").equals("female")) {
			student.setGender("F");
		}
		entity.setStudent(student);

		success = studm.addStudent(entity);
		out.println(success);

		if (success > 0) {
			pullInfo(request, response);
		}

	}
	protected void invoiceView(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		entity = paym.retrieveInvoices(entity);
		
		invoices = entity.getUser().getInvoices();
		pInvoices = paym.paidInv(entity); //Added: 04/04/13 calls the method to pull paid invoices from the database
		entity.getUser().setPaidInvoices(pInvoices);
		request.setAttribute("invoices", invoices);
		request.setAttribute("pInvoices", pInvoices); //Added: 04/04/13, sets an attribute of the paid invoices to show them in the jsp
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Invoices.jsp");
		dispatcher.forward(request, response);
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("param").equals("viewStu"))
		{
		studentView(request, response);
		}
		if(request.getParameter("param").equals("viewInv"))
		{
		invoiceView(request, response);
		}
	}
	protected void selectInvoice(HttpServletRequest request,
			HttpServletResponse response, String keyword) throws IOException, ServletException

	{
		HttpSession newSession = request.getSession();
			PrintWriter out = response.getWriter();
			if(keyword.equalsIgnoreCase("View"))
				{
		int id = Integer.parseInt(request.getParameter("Invoice"));
			for (Invoice inv : entity.getUser().getInvoices()) {
			if (inv.getInvoiceID() == id) {
				String xml = paym.genInvoice(inv);
				out.println(xml);
			}
			}
				}
			if(keyword.equalsIgnoreCase("View Paid"))
				{
		int vid = Integer.parseInt(request.getParameter("pInvoice"));
		out.println(entity.getUser().getPaidInvoices().size());
			for (Invoice pinv : entity.getUser().getPaidInvoices()) {
			if (pinv.getInvoiceID() == vid) {
				
				String xml = paym.genInvoice(pinv);
				out.println(xml);
				
			}
			} 
				if(keyword.equalsIgnoreCase("Pay"))
				{
					int pid = Integer.parseInt(request.getParameter("Invoice"));
					newSession.setAttribute("invoiceID", pid);
					entity.getInvoice().setInvoiceID(pid);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Payment.jsp");
		dispatcher.forward(request, response);
				}
				}
				}
		
		
	
	protected void selectClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession newSession = request.getSession();
		PrintWriter out = response.getWriter();
		ArrayList<Course> courseInfo = new ArrayList<Course>();
		int id = Integer.parseInt(request.getParameter("Classes"));
		for (Course course : entity.getRetrieval().getCourses()) {
			if (course.getclassID() == id) {
				courseInfo.add(course);

			}

		}

		newSession.setAttribute("classInfo", courseInfo);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/assignClass.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String segregate = request.getParameter("authenticate");
		if (segregate.equals("Login")) {
			validUser(request, response);
		}
		if (segregate.equals("Select")) {
			selectClass(request, response);
		}
		if (segregate.equals("Complete")) {
			try {
				addStudent(request, response);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (segregate.equals("View Current Invoice"))
		{
			selectInvoice(request, response, "View Paid");
		}
		if (segregate.equals("Register")) {
			Register(request, response);
		}
		if (segregate.equals("View Info")) {
			selectStu(request, response);
		}
		if (segregate.equals("Confirm")) {
			assignClass(request, response);
		}
		if (segregate.equals("View Invoice")) {
			selectInvoice(request, response, "View");
		}
		if (segregate.equals("Pay Invoice"))
		{
			selectInvoice(request,response, "Pay");
		}
		if (segregate.equals("Confirm Payment"))
		{
			try {
				processPayment(request,response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
	}
}
