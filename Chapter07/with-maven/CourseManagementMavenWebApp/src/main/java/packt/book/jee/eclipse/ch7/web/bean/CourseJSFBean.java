package packt.book.jee.eclipse.ch7.web.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import packt.book.jee.eclipse.ch7.dto.CourseDTO;
import packt.book.jee.eclipse.ch7.ejb.CourseBeanRemote;

@ManagedBean(name="Course")
public class CourseJSFBean {
	@EJB
	CourseBeanRemote courseBean;
	
	public List<CourseDTO> getCourses() {
		return courseBean.getCourses();
	}
}
