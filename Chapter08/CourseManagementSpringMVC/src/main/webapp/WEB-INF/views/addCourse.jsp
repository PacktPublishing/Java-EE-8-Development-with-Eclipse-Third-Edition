<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
	<h2>${title}:</h2>
	<c:if test="${not empty error}">
		<span style="color:red;">
			${error}<br>
		</span>
	</c:if>
	
	<c:set var="actionPath" value="${pageContext.request.contextPath}/doAddCourse"/>
	<form method="post" action="${actionPath}">
		<table>
			<tr>
				<td>Course Name:</td>
				<td><input type="text" name="name" value="${course.name}"> </td>
			</tr>
			<tr>
				<td>Credits:</td>
				<td><input type="text" name="credits" value="${course.credits}"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${course.id}">
	</form>
</body>
</html>