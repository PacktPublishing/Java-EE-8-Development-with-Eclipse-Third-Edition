package packt.jee.eclipse.ws.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public class CourseManagementService {

	public Courses getCourses() {
		//Here courses could be fetched from database using, 
		//for example, JDBC or JDO. But to keep this example
		//simple, we will return hard-coded list of courses
		
		List<Course> courses = new ArrayList<Course>();
		
		courses.add(new Course(1, "Course-1", 4));
		courses.add(new Course(2, "Course-2", 3));
		
		return new Courses(courses);
	}

/*	
	public List<Course> getCourses() {
		//Here courses could be fetched from database using, 
		//for example, JDBC or JDO. But to keep this example
		//simple, we will return hard-coded list of courses
		
		List<Course> courses = new ArrayList<Course>();
		
		courses.add(new Course(1, "Course-1", 4));
		courses.add(new Course(2, "Course-2", 3));
		
		return courses;
	}
*/	
	public Course getCourse(@WebParam(name="courseId") int courseId) {
		//Here again we could get course detail from database using 
		//JDBC or JDO. But to keep this example
		//simple, we will return hard-coded course
		return new Course(1,"Course-1",4);
	}
	
}
