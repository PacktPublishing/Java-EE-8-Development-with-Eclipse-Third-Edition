package packt.jee.eclipse.rest.ws.dto;

import javax.json.bind.annotation.JsonbProperty;

public class Course {
	@JsonbProperty
	private int id;
	@JsonbProperty("course_name")
	private String name;
	@JsonbProperty
	private int credits;
	@JsonbProperty
	private Teacher teacher;
	
	public Course() {}
	
	public Course (int id, String name, int credits, Teacher teacher) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.teacher = teacher;
	}
	
	//Getters and setters follow
	
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
