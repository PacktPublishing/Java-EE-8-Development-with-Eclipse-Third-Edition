package packt.book.jee.eclipse.ch7.web.servlet;

import java.io.IOException;

import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@BasicAuthenticationMechanismDefinition(realmName="basic")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"manager"} ))
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Welcome to Management Page!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
