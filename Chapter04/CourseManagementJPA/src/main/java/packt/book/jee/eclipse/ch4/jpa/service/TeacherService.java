package packt.book.jee.eclipse.ch4.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import packt.book.jee.eclipse.ch4.jpa.bean.Teacher;
import packt.book.jee.eclipse.ch4.jpa.service_bean.EntityManagerFactoryBean;

public class TeacherService {
	private EntityManagerFactory factory;
	
	public TeacherService (EntityManagerFactoryBean factoryBean) {
		factory = factoryBean.getEntityManagerFactory();
	}
	
	public void addTeacher (Teacher teacher) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(teacher);
		txn.commit();
	}
	
	public List<Teacher> getTeacher() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
		TypedQuery<Teacher> tq = em.createQuery(cq);
		List<Teacher> teachers = tq.getResultList();
		em.close();
		return teachers;
	}

	public Teacher getTeacher (int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Teacher.class, id);
	}
}
