package packt.book.jee_eclipse.ch2.bean;

import javax.servlet.http.HttpServletRequest;

public class JSPFormBean {
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validateUser()
	{
		System.out.println("user name = " + userName + ", password = " + password);
		if ("admin".equals(this.userName) && "admin".equals(this.password))
		{
			System.out.println("Valid user");
			return true;
		}
		System.out.println("Invalid user");
		return false;
	}
	public boolean isFormPost(HttpServletRequest req)
	{
		System.out.println("In isFormPost, request = " + req);
		if (req == null)
			return false;
		boolean ret = "POST".equalsIgnoreCase(req.getMethod()) && req.getParameter("submit") != null;
		System.out.println("ret = " + ret);
		return ret;
	}
}
