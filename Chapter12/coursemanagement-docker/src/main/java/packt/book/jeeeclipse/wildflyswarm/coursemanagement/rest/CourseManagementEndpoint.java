package packt.book.jeeeclipse.wildflyswarm.coursemanagement.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/course_management")
public class CourseManagementEndpoint {

	@Inject
	private CourseManagementJPAFactory jpaFactory;
	
	@GET
	@Path("/courses")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Course> doGet() {
		EntityManager entityManager = jpaFactory.getEntityManager();
		TypedQuery<Course> courseQuery = entityManager.createNamedQuery("Course.findAll", Course.class);
		List<Course> courses = courseQuery.getResultList();
		return courses;
	}
}