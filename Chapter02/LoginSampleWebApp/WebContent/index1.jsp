<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<%@ page import="packt.book.jee_eclipse.ch2.bean.*" %>
                          
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
	<c:out value="Hello World"></c:out>
<br>

<c:out value="Method = ${pageContext.request.method}"/><br>

<c:if test="${\"POST\".equalsIgnoreCase(pageContext.request.method) && pageContext.request.getParameter(\"submit\") != null}">
	<c:out value="Condition worked"></c:out><br>
</c:if>

<jsp:useBean id="formBean" class="packt.book.jee_eclipse.ch2.bean.JSPFormBean" scope=""/>
<c:set var="isPost" value="${formBean.isFormPost(pageContext.request)}"/>
<c:out value="isFormPost = ${isPost}"></c:out>
<c:if test="${isPost}">
	<jsp:setProperty name="formBean" property="*"/>
	<c:set var="validUser" scope="page" value="${formBean.validateUser()}"/>
	<br>
	<c:out value="${validUser}"></c:out>
</c:if>
<%
/*
	String errMsg = null;
	//first check if the form was submitted
	if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null)
	{
		//form was submitted
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
		{
			//valid user
			out.println("<h2>Welcome admin !</h2>");
			out.println("Yor are successfully logged in");
			return;
		} 
		else
		{
			//invalid user. Set error message
			errMsg = "Invalid user id or password. Please try again";
		}
	}
*/	
%>
<body>
	<h2>Login:</h2>
	<!-- Check error message. If it is set, then display it -->
	<form method="post">
	 	User Name: <input type="text" name="userName"><br>
		Password: <input type="password" name="password"><br>
		<button type="submit" name="submit">Submit</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>