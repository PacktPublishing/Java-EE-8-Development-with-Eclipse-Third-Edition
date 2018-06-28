package packt.jee.eclipse.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component; 

@Component 
public class CourseService { 

 @Autowired 
 private @Qualifier("courseDAO1") ICourseDAO courseDAO; 

 public ICourseDAO getCourseDAO() { 
   return courseDAO; 
 } 
} 