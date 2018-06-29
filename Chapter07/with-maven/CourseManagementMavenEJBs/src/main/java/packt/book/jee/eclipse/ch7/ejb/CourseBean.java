package packt.book.jee.eclipse.ch7.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import packt.book.jee.eclipse.ch7.dto.CourseDTO;
import packt.book.jee.eclipse.ch7.jpa.Course;

/**
 * Session Bean implementation class CourseBean
 */
@Stateless
@Remote
public class CourseBean implements CourseBeanRemote {

	@PersistenceContext
	EntityManager entityManager;

    public List<Course> getCourseEntities() {
    	//Use named query created in Course entity using @NameQuery annotation.
    	TypedQuery<Course> courseQuery = entityManager.createNamedQuery("Course.findAll", Course.class);
    	return courseQuery.getResultList();
    }
    
	public List<CourseDTO> getCourses() {
		//get course entities first
		List<Course> courseEntities = getCourseEntities();
		
		//create list of course DTOs. This is the result we will return
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		
		for (Course courseEntity : courseEntities) {
			//Create CourseDTO from Course entity
			CourseDTO course = new CourseDTO();
			course.setId(courseEntity.getId());
			course.setName(courseEntity.getName());
			course.setCredits(course.getCredits());
			courses.add(course);
		}
		return courses;
	}
}
