package packt.jee.eclipse.jms.dto;

import java.io.Serializable;

public class CourseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int credits;
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
}