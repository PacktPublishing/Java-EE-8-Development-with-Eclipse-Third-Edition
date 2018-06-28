package packt.book.jee.eclipse.ch4.jpa.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@ManagedBean (name="teacher")
@RequestScoped
@Entity
public class Teacher extends Person {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Column(name="designation")
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public boolean isValidTeacher() {
		return getFirstName() != null;
	}
}
