package packt.book.jee.eclipse.ch7.web.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@BasicAuthenticationMechanismDefinition(realmName="basic")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "manager"} ))
public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@Inject
	private SecurityContext securityContext;
	
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (securityContext.isCallerInRole("manager")) {
			request.getRequestDispatcher("/ManagementServlet").forward(request, response);
		} else {
			response.getWriter().append("Welcome to Admin Page!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
