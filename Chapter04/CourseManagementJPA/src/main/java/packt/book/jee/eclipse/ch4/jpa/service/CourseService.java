package packt.book.jee.eclipse.ch4.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import packt.book.jee.eclipse.ch4.jpa.bean.Course;
import packt.book.jee.eclipse.ch4.jpa.service_bean.EntityManagerFactoryBean;

public class CourseService {
	private EntityManagerFactory factory;

	public CourseService(EntityManagerFactoryBean factoryBean) {
		factory = factoryBean.getEntityManagerFactory();
	}

	public List<Course> getCourses() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		TypedQuery<Course> tq = em.createQuery(cq);
		List<Course> courses = tq.getResultList();
		em.close();
		return courses;
	}

	public void addCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(course);
		txn.commit();
	}
	
	public void updateCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.merge(course);
		txn.commit();
	}
	
	public Course getCourse (int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Course.class, id);
	}
	
	public void deleteCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Course mergedCourse = em.find(Course.class, course.getId());
		em.remove(mergedCourse);
		txn.commit();
	}
}
