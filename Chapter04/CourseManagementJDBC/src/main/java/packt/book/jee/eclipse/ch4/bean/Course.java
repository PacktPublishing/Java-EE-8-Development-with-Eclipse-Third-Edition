package packt.book.jee.eclipse.ch4.bean;

import java.sql.SQLException;
import java.util.List;

import packt.book.jee.eclipse.ch4.dao.CourseDAO;

public class Course {
	private int id;
	private String name;
	private int credits;
	private Teacher teacher;
	private int teacherId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public boolean isValidCourse() {
		return name != null && credits != 0;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
	public void addCourse() throws SQLException {
		CourseDAO.addCourse(this);
	}
	public List<Course> getCourses() throws SQLException {
		return CourseDAO.getCourses();
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
}
