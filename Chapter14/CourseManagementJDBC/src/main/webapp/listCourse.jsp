<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Courses</title>
</head>
<body>
	<c:catch var="err">
		<jsp:useBean id="courseBean" class="packt.book.jee.eclipse.ch4.bean.Course"/>
		<c:set var="courses" value="${courseBean.getCourses()}"/>
	</c:catch>
	<c:choose>
		<c:when test="${err != null}">
			<c:set var="errMsg" value="${err.message}"/>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<h2>Courses:</h2>
	<c:if test="${errMsg != null}">
		<span style="color: red;">
			<c:out value="${errMsg}"></c:out>
		</span>
	</c:if>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Credits</th>
			<th>Teacher</th>
		</tr>
		<c:forEach items="${courses}" var="course">
			<tr>
				<td>${course.id}</td>
				<td>${course.name}</td>
				<td>${course.credits}</td>
				<c:choose>
					<c:when test="${course.teacher != null}">
						<td>${course.teacher.firstName}</td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>
</html>