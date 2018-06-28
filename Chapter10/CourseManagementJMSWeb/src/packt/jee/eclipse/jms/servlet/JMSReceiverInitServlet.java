package packt.jee.eclipse.jms.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import packt.jee.eclipse.jms.CourseQueueReceiver;
import packt.jee.eclipse.jms.CourseTopicSubscriber;

/**
 * Servlet implementation class JMSReceiverInitServlet
 */
@WebServlet(urlPatterns="/JMSReceiverInitServlet", loadOnStartup=1)
public class JMSReceiverInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CourseQueueReceiver courseQueueReceiver = null;
	private CourseTopicSubscriber courseTopicSubscriber = null;

	private CourseQueueReceiver courseQueueReceiver1 = null;
	private CourseTopicSubscriber courseTopicSubscriber1 = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JMSReceiverInitServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	try {
			courseQueueReceiver = new CourseQueueReceiver("Receiver1");
			courseQueueReceiver1 = new CourseQueueReceiver("Receiver2");
			courseTopicSubscriber = new CourseTopicSubscriber("Subscriber1");
			courseTopicSubscriber1 = new CourseTopicSubscriber("Subscriber2");
		} catch (Exception e) {
			log("Error creating CourseQueueReceiver", e);
		}
    }

    @Override
    public void destroy() {
    	if (courseQueueReceiver != null)
    		courseQueueReceiver.stop();
    	if (courseTopicSubscriber != null)
    		courseTopicSubscriber.stop();

    	if (courseQueueReceiver1 != null)
    		courseQueueReceiver1.stop();
    	if (courseTopicSubscriber1 != null)
    		courseTopicSubscriber1.stop();
    	
    	super.destroy();
    }
}
