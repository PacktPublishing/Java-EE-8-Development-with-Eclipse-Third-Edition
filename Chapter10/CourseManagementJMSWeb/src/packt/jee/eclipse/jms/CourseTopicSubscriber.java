package packt.jee.eclipse.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

import packt.jee.eclipse.jms.dto.CourseDTO;

public class CourseTopicSubscriber {

	private TopicConnection connection;
	private TopicSession session;
	private Topic topic;
	
	private String subscriberName;

	public CourseTopicSubscriber(String name) throws Exception{
		
		this.subscriberName = name;
		
		InitialContext initCtx = new InitialContext();
		TopicConnectionFactory connectionFactory = (TopicConnectionFactory)initCtx.lookup("jms/CourseManagementCF");
		connection = connectionFactory.createTopicConnection();
		connection.start();
		session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic)initCtx.lookup("jms/courseManagementTopic");
		
		TopicSubscriber subscriber = session.createSubscriber(topic);
		subscriber.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				if (message instanceof ObjectMessage == false)
					return; //don't do anything if message is not of type ObjectMessage
				
				//we expect ObjectMessage here; of type CourseDTO
				//Skipping validation
				try {
					CourseDTO course = (CourseDTO) ((ObjectMessage)message).getObject();
					
					//process addCourse action. For example, save it in database
					
					System.out.println("Received addCourse notification for Course name - " 
							+ course.getName() + " in Subscriber " + subscriberName);
					
				} catch (JMSException e) {
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
