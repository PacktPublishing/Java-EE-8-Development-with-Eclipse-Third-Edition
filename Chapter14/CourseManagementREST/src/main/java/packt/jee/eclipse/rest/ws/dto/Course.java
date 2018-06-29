package packt.jee.eclipse.rest.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
	@XmlAttribute
	private int id;
	@XmlElement(name="course_name")
	private String name;
	private int credits;
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
