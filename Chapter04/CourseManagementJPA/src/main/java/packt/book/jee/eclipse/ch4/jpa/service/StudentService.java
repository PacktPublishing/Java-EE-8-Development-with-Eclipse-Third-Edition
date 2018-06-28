package packt.book.jee.eclipse.ch4.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import packt.book.jee.eclipse.ch4.jpa.bean.Student;
import packt.book.jee.eclipse.ch4.jpa.service_bean.EntityManagerFactoryBean;

public class StudentService {
	private EntityManagerFactory factory;

	public StudentService (EntityManagerFactoryBean factoryBean) {
		factory = factoryBean.getEntityManagerFactory();
	}
	
	public void addStudent (Student student) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(student);
		txn.commit();
	}
	
	public List<Student> getStudents() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		TypedQuery<Student> tq = em.createQuery(cq);
		List<Student> students = tq.getResultList();
		em.close();
		return students;
	}

}
