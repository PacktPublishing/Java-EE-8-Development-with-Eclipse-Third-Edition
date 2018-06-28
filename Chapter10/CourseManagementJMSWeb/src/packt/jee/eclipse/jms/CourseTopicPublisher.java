package packt.jee.eclipse.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

import packt.jee.eclipse.jms.dto.CourseDTO;

public class CourseTopicPublisher {
	private TopicConnection connection;
	private TopicSession sessoin;
	private Topic topic;
	
	public CourseTopicPublisher() throws Exception {
		InitialContext initCtx = new InitialContext();
		TopicConnectionFactory connectionFactory = (TopicConnectionFactory)initCtx.
				lookup("jms/CourseManagementCF");
		connection = connectionFactory.createTopicConnection();
		connection.start();
		sessoin = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic)initCtx.lookup("jms/courseManagementTopic");
	}
	
	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	};
	
	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void publishAddCourseMessage (CourseDTO course) throws Exception {
		TopicPublisher sender = sessoin.createPublisher(topic);
		ObjectMessage objMessage = sessoin.createObjectMessage(course);
		sender.send(objMessage);
	}
	
}
