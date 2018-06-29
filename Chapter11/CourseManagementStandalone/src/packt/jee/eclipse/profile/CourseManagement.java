package packt.jee.eclipse.profile;

import java.io.IOException;

import packt.jee.eclipse.profile.bean.CourseBean;

public class CourseManagement {

	public static void main(String[] args) throws IOException {

		final CourseBean courseBean = new CourseBean();
		
		System.out.println("Type any character to get courses. Type q to quit.");

		int ch, threadIndex = 0;
		while ((ch = System.in.read()) != -1) {
			if (ch != 13 && ch != 10) { //ignore new lines
				if (ch == 'q') //quit if user types q
					break;
				
				threadIndex++; //used for naming the thread
				Thread getCourseThread = new Thread("getCourseThread" + threadIndex) {
					
					@Override
					public void run() {
						System.out.println("Getting courses");
						courseBean.getCourses();						
						System.out.println("Got courses");
					}
				};
				
				//Set this thread as Daemon so that application can exit 
				//immediately when user enters 'q'
				getCourseThread.setDaemon(true);
				
				getCourseThread.start(); 
				
				System.out.println("Type any character to get courses. Type q to quit.");
			}
		}
		
		System.out.println("Quitting ...");
	}
}
