package data_access;

import javax.sql.DataSource;

import model.Entity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Update {
	DataSource source = getDataSource();
	JdbcTemplate template = new JdbcTemplate(source);
	int success = 0;

	private static DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/studio");
		dataSource.setUsername("root");
		dataSource.setPassword("lolcakes");
		return dataSource;
	}

	public int updateStudent(Entity entity, String keyword) {
		if (keyword.equals("enroll")) {
			success = this.template.update(
					"update student set classID = ? where studentID = ?",
					new Object[] {
							new Integer(entity.getCourse().getclassID()),
							new Integer(entity.getStudent().getStudentID()) });
		}

		return success;

	}
	public int payInvoice(int invoiceID)
	{
	success = this.template.update(
					"update invoice set isPaid = 1 where invoiceID = ?",
					new Object[] {
							new Integer(invoiceID)});
	return success;
	}
	
}
