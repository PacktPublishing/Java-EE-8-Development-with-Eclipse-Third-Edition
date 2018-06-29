package packt.jee.eclipse.profile.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import packt.jee.eclipse.profile.dao.CourseDAO;
import packt.jee.eclipse.profile.dto.CourseDTO;

public class CourseService {
	
	private CourseDAO courseDAO = new CourseDAO();
	
	//Dummy cached data used only to simulate large
	//memory allocation
	private byte[] cachedData = null; 
	
	public synchronized List<CourseDTO> getCourses() {
		
		//To simulate large memory allocation,
		//let's assume we are reading serialized cache data 
		//and storing it in cachedData member
		try {
			this.cachedData = generateDummyCachedData();
		} catch (IOException e) {
			//ignore
		}
		
		return courseDAO.getCourses();
	}
	
	private byte[] generateDummyCachedData() throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] dummyData = "Dummy cached data".getBytes();
		
		//write 100000 times
		for (int i = 0; i < 100000; i++)
			byteStream.write(dummyData);
		
		byte[] result = byteStream.toByteArray();
		byteStream.close();
		return result;
	}
 }
