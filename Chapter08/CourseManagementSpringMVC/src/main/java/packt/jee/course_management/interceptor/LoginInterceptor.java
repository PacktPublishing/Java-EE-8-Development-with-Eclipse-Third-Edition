package packt.jee.course_management.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import packt.jee.course_management.dto.UserDTO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
		
		//get session from request
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		
		//Check if the current reeust is for /login. In that case
		//do nothing, else we will execute the request in loop
		//Intercept only if request is not /login
		String context = request.getContextPath();
		if (!request.getRequestURI().equals(context + "/login") && 
			(user == null || user.getUserName() == null)) {
			//User is not logged in. Redirect to /login
			response.sendRedirect(request.getContextPath() + "/login");
			//do not process this request further
			return false;
		}
		
		return true;
	}

}
