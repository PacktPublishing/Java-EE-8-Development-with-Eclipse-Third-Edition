package packt.book.jeeeclipse.springboot.coursemanagementspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;

	@RequestMapping(value = "/course_management/courses", method = RequestMethod.GET)
    public Iterable<Course> getCourses() {
		return courseRepository.findAll();
    }
}
