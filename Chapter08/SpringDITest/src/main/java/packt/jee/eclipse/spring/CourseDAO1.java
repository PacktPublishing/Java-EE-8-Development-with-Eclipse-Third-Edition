package packt.jee.eclipse.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component; 

@Component 
@Qualifier("courseDAO1") 
public class CourseDAO1 implements ICourseDAO {
}
