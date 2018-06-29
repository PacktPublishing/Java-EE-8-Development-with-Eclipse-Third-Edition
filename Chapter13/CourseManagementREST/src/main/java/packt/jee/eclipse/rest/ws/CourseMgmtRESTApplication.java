package packt.jee.eclipse.rest.ws;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("services")
public class CourseMgmtRESTApplication extends ResourceConfig {
	
	public CourseMgmtRESTApplication () {
		packages("packt.jee.eclipse.rest.ws.services");
	}

}
