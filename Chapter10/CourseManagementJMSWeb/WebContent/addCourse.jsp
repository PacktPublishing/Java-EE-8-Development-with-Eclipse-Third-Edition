<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page session="true" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Course</title>
</head>
<body>
	<!-- Check if form is posted -->
	<c:if test="${\"POST\".equalsIgnoreCase(pageContext.request.method) 
			&& pageContext.request.getParameter(\"submit\") != null}">
			
		<!-- Create CourseJSPBean -->	
		<jsp:useBean id="courseService" class="packt.jee.eclipse.jms.jsp_beans.CourseJSPBean" scope="page"></jsp:useBean>
		
		<!-- Set Bean properties with values from form submission -->
		<jsp:setProperty property="name" name="courseService" param="course_name"/>
		<jsp:setProperty property="credits" name="courseService" param="course_credits"/>
		
		<!-- Call addCourse method of the bean -->
		${courseService.addCourse(pageContext.request)}	
		<b>Course detailed are sent to a JMS Queue. It will be processed later</b>
	</c:if>
	
	<h2>New Course:</h2>
	
	<!-- Course data input form -->
	<form method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td>
					<input type="text" name="course_name">
				</td>
			</tr>
			<tr>
				<td>Credits:</td>
				<td>
					<input type="text" name="course_credits">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" name="submit">Add</button>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>