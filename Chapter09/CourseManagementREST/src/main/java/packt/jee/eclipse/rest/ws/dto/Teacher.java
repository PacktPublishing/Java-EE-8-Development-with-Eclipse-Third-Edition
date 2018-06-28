package packt.jee.eclipse.rest.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {
	@XmlAttribute
	private int id;
	@XmlElement(name="teacher_name")
	private String name;
	
	//constructors
	public Teacher() {}
	
	public Teacher (int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//Getter and setters follow
	
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
	
	
}
