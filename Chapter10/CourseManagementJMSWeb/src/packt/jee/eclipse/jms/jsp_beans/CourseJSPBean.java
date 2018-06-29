package packt.jee.eclipse.jms.jsp_beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import packt.jee.eclipse.jms.CourseQueueSender;
import packt.jee.eclipse.jms.dto.CourseDTO;

public class CourseJSPBean {
	
	private CourseDTO course = new CourseDTO();
//	private CourseQueueSender courseQueueSender;	
	
//	public CourseJSPBean() {
//		try {
//			courseQueueSender = new CourseQueueSender();
//		} catch (Exception e) {
//			e.printStackTrace();
//			//TODO: log error
//		}
//	}
	
//	@Override
//	protected void finalize() throws Throwable {
//		if (courseQueueSender != null)
//			courseQueueSender.close();
//		super.finalize();
//	}
	
	public void setId(int id) {
		course.setId(id);
	}
	public String getName() {
		return course.getName();
	}
	public void setName(String name) {
		course.setName(name);
	}
	public int getCredits() {
		return course.getCredits();
	}
	public void setCredits(int credits) {
		course.setCredits(credits);
	}
	public void addCourse(HttpServletRequest request) throws Exception {
		//get HTTP session
		HttpSession session = request.getSession(true);
		
		//look for instance of CourseQueueSender in Session
		CourseQueueSender courseQueueSender = (CourseQueueSender)session.
												getAttribute("CourseQueueSender");
		if (courseQueueSender == null) {
			//Create instance of CourseQueueSender and save in Session
			courseQueueSender = new CourseQueueSender();
			session.setAttribute("CourseQueueSender", courseQueueSender);
		}
		
		//TODO: perform input validation
		if (courseQueueSender != null) {
			try {
				courseQueueSender.sendAddCourseMessage(course);
			} catch (Exception e) {
				e.printStackTrace();
				//TODO: log exception
			}
		}
	}
}
