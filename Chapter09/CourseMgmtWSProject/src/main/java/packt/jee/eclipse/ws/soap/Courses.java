package packt.jee.eclipse.ws.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Courses {
	@XmlAnyElement
	public List<Course> courseList;
	
	public Courses() {
		
	}
	
	public Courses (List<Course> courseList) {
		this.courseList = courseList;
	}
}
