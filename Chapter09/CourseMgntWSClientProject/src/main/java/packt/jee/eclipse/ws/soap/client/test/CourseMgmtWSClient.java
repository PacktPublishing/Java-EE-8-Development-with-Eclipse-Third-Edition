package packt.jee.eclipse.ws.soap.client.test;

import packt.jee.eclipse.ws.soap.client.Course;
import packt.jee.eclipse.ws.soap.client.CourseManagementService;
import packt.jee.eclipse.ws.soap.client.CourseManagementServiceService;

public class CourseMgmtWSClient {

	public static void main(String[] args) {
		CourseManagementServiceService service = new CourseManagementServiceService();
		CourseManagementService port = service.getCourseManagementServicePort();
		Course course = port.getCourse(1);
		System.out.println("Course name = " + course.getName());
	}

}
