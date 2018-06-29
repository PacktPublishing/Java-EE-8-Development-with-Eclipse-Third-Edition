package packt.jee.course_management_jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import packt.jee.course_management_jpa.entity.Course;
import packt.jee.course_management_jpa.entity.JPAEntityFactoryBean;

@Component
public class CourseDAO {
	@Autowired
	JPAEntityFactoryBean entityFactoryBean;

	public List<Course> getCourses() {
		//Get entity manager
		EntityManagerFactory emf = entityFactoryBean.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		//Execute Query
		TypedQuery<Course> courseQuery = em.createNamedQuery("Course.findAll", Course.class);
    	List<Course> courses = courseQuery.getResultList();
    	em.close();
    	
    	return courses;
	}
}
