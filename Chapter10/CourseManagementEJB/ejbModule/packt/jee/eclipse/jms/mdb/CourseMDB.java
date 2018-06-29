package packt.jee.eclipse.jms.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: CourseMDB
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destinationType", 
						propertyValue = "javax.jms.Queue"), 
				@ActivationConfigProperty(propertyName = "destination", 
						propertyValue = "CourseManagementQueue")
		}, 
		mappedName = "jms/courseManagementQueue")
public class CourseMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public CourseMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	
    	if (message instanceof MapMessage == false) {
        	System.out.println("addCourse message received in CourseMDB");
    		return;
    	}
    	
    	//TODO: process message
    	
    	MapMessage mapMessage = ((MapMessage)message);
    	try {
	    	String courseName = mapMessage.getString("name");
	    	int credits = mapMessage.getInt("credits");
	        System.out.println("addCourse message received in CourseMDB for course - " + courseName);
    	} catch (Exception e) {
    		//TODO: log exception
    		e.printStackTrace();
    	}
    }

}
