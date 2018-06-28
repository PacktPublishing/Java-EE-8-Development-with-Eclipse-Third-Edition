package packt.book.jee.eclipse.ch4.bean;

import java.sql.SQLException;
import java.util.List;

import packt.book.jee.eclipse.ch4.dao.TeacherDAO;

public class Teacher extends Person {
	private String designation;

	private TeacherDAO teacherDAO = new TeacherDAO();
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public boolean isValidTeacher() {
		return getFirstName() != null;
	}
	public void addTeacher() throws SQLException {
		teacherDAO.addTeacher(this);
	}
	public List<Teacher> getTeachers() throws SQLException {
		return teacherDAO.getTeachers();
	}
}
