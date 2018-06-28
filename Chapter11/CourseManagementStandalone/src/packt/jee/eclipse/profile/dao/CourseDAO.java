package packt.jee.eclipse.profile.dao;

import java.util.ArrayList;
import java.util.List;

import packt.jee.eclipse.profile.dto.CourseDTO;

public class CourseDAO {

	public List<CourseDTO> getCourses() {
		//No real database access takes place here. 
		//We will just simulate a long running database operation
				
		try {
			Thread.sleep(30000); //wait 30 seconds 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return dummy/empty list
		return new ArrayList<>();
	}
}
