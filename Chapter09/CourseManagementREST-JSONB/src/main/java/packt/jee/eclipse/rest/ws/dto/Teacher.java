package packt.jee.eclipse.rest.ws.dto;

import javax.json.bind.annotation.JsonbProperty;

public class Teacher {
	@JsonbProperty
	private int id;
	@JsonbProperty("teacher_name")
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
