package packt.book.jee.eclipse.ch4.jpa.bean;

import static javax.persistence.TemporalType.DATE;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.ManyToMany;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@ManagedBean (name="student")
@RequestScoped 
@Entity
public class Student extends Person {
	private static final long serialVersionUID = 1L;
	
	@Temporal(DATE)
	@Column(name="enrolled_since")
	private Date enrolledsince;
	
	@ManyToMany(cascade = { MERGE, REFRESH })
	@JoinTable(name = "Course_Student", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	List<Course> courses;

	public Date getEnrolledsince() {
		return enrolledsince;
	}

	public void setEnrolledsince(Date enrolledsince) {
		this.enrolledsince = enrolledsince;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
