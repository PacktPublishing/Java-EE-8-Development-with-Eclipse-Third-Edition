package packt.jee.eclipse.profile.bean;

import java.util.List;

import packt.jee.eclipse.profile.dto.CourseDTO;
import packt.jee.eclipse.profile.service.CourseService;

public class CourseBean {
	private CourseService courseService = new CourseService();
	
	public List<CourseDTO> getCourses() {
		return courseService.getCourses();
	}
}
