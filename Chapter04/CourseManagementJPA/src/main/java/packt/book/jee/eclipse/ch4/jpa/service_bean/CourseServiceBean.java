package packt.book.jee.eclipse.ch4.jpa.service_bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import packt.book.jee.eclipse.ch4.jpa.bean.Course;
import packt.book.jee.eclipse.ch4.jpa.service.CourseService;

@ManagedBean(name="courseServiceBean")
@RequestScoped
public class CourseServiceBean {
	
	private CourseService courseService ;
	
	@ManagedProperty(value="#{emFactoryBean}")
	private EntityManagerFactoryBean factoryBean;
	
	@ManagedProperty(value="#{course}")
	private Course course;

	private String errMsg= null;

	@PostConstruct
	public void init() {
		courseService = new CourseService(factoryBean);
	}
	
	public void setFactoryBean(EntityManagerFactoryBean factoryBean) {
		this.factoryBean = factoryBean;
	}	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String addCourse() {
		courseService.addCourse(course);
		return "listCourse";
	}
	
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

}
