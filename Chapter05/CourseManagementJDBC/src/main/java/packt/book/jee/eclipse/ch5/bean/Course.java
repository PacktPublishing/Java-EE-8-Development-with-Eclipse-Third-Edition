package packt.book.jee.eclipse.ch5.bean;

import java.sql.SQLException;
import java.util.List;

import packt.book.jee.eclipse.ch5.dao.CourseDAO;
import packt.book.jee.eclipse.ch5.error.EnrollmentFullException;

public class Course {
	private int id;
	private String name;
	private int credits;
	private Teacher teacher;
	private int teacherId;
	//Hard-coded min and max student values, but ideally should be 
	//stored and obatined from database
	private int minStudents = 10;
	private int maxStudents = 60;
	private CourseDAO courseDAO = new CourseDAO();
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
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
		return name != null && credits != 0 && name.trim().length() > 0;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
	public void addCourse() throws SQLException {
		courseDAO.addCourse(this);
	}
	public List<Course> getCourses() throws SQLException {
		return courseDAO.getCourses();
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getMinStudents() {
		return minStudents;
	}
	public void setMinStudents(int minStudents) {
		this.minStudents = minStudents;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	public void addStudent (Student student) 
			throws EnrollmentFullException, SQLException {
		//get current enrollement first
		int currentEnrollment = courseDAO.getNumStudentsInCourse(id);
		if (currentEnrollment >= getMaxStudents())
			throw new EnrollmentFullException("Course if full. Enrollment closed");
		courseDAO.enrollStudentInCourse(id, student.getId());
	}
}
