package packt.book.jeeeclipse.wildflyswarm.coursemanagement.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class CourseManagementJPAFactory {
	private EntityManager _entityManager;
	
	public EntityManager getEntityManager() {
		if (_entityManager != null) return _entityManager;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("coursemanagement");
		_entityManager = factory.createEntityManager();
		return _entityManager;
	}
}
