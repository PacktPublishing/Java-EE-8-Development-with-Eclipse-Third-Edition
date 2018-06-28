package packt.jee.eclipse.spring; 
 
import org.springframework.context.ApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
 
public class SpringMain { 
 
  public static void main (String[] args) { 
    //create ApplicationContext 
    ApplicationContext ctx = new 
     ClassPathXmlApplicationContext("context.xml"); 
    //Get bean 
    CourseService courseService = (CourseService) 
     ctx.getBean("courseService"); 
    //Get and print CourseDAO. It should not be null 
    System.out.println("CourseDAO = " + 
     courseService.getCourseDAO()); 
  } 
} 