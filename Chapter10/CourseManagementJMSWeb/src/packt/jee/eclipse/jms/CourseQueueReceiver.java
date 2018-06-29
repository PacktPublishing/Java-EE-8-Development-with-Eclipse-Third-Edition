package packt.jee.eclipse.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

import packt.jee.eclipse.jms.dto.CourseDTO;

public class CourseQueueReceiver {

	private QueueConnection connection;
	private QueueSession session;
	private Queue queue;
	
	private String receiverName;

	private CourseTopicPublisher topicPublisher;
	
	public CourseQueueReceiver(String name) throws Exception{
		
		//Save receiver name
		this.receiverName = name;
		
		//Lookup JMS connection factory
		InitialContext initCtx = new InitialContext();
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory)initCtx.lookup("jms/CourseManagementCF");
		
		//create JMS connection
		connection = connectionFactory.createQueueConnection();
		connection.start();
		
		//create JMS session
		session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		//lookup queue
		queue = (Queue)initCtx.lookup("jms/courseManagementQueue");
		
		topicPublisher = new CourseTopicPublisher();
		
		QueueReceiver receiver = session.createReceiver(queue);
		//register message listener
		receiver.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof ObjectMessage == false)
					return; //don't do anything if message is not of type ObjectMessage
				
				//we expect ObjectMessage here; of type CourseDTO
				//Skipping validation
				try {
					CourseDTO course = (CourseDTO) ((ObjectMessage)message).getObject();
					
					//process addCourse action. For example, save it in database
					
					System.out.println("Received addCourse message for Course name - " + 
							course.getName() + " in Receiver " + receiverName);
					
					if (topicPublisher != null)
						topicPublisher.publishAddCourseMessage(course);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					//TODO: handle and log exception
				}
			}
		});
	}
	
	public void stop() {
		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
				//TODO: log exception
			}
		}
	}
}
