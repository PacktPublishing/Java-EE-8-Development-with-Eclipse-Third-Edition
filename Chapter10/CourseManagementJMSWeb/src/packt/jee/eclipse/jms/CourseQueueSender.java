package packt.jee.eclipse.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

import packt.jee.eclipse.jms.dto.CourseDTO;

public class CourseQueueSender {
	private QueueConnection connection;
	private QueueSession sessoin;
	private Queue queue;
	

	public CourseQueueSender() throws Exception {
		//Create JMS Connection, session and queue objects
		InitialContext initCtx = new InitialContext();
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory)initCtx.lookup("jms/CourseManagementCF");
		connection = connectionFactory.createQueueConnection();
		connection.start();
		sessoin = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue)initCtx.lookup("jms/courseManagementQueue");
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}
	
	public void close() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendAddCourseMessage (CourseDTO course) throws Exception {
		//Send CourseDTO object to JMS Queue
		QueueSender sender = sessoin.createSender(queue);
		ObjectMessage objMessage = sessoin.createObjectMessage(course);
		sender.send(objMessage);
	}
}
