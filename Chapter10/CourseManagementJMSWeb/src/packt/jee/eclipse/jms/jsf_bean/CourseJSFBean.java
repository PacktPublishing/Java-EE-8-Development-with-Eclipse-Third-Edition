package packt.jee.eclipse.jms.jsf_bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import packt.jee.eclipse.jms.dto.CourseDTO;;

@Named("course")
@RequestScoped
public class CourseJSFBean {
	private CourseDTO courseDTO = new CourseDTO();
	
	@Inject
	private CourseManagedMsgSenderBean courseMessageSender;

	public String getName() {
		return this.courseDTO.getName();
	}
	public void setName(String name) {
		this.courseDTO.setName(name); 
	}
	public int getCredits() {
		return this.courseDTO.getCredits();
	}
	public void setCredits(int credits) {
		this.courseDTO.setCredits(credits);;
	}
	
	public void addCourse() throws Exception {
		//skipping validation
		//TODO: handle exception properly and show error message
		courseMessageSender.addCourse(courseDTO);
	}
}
