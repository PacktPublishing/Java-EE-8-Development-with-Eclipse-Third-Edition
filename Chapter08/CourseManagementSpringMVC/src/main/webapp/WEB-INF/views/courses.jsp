<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function canDelete (courseName) {
		return confirm("Are you sure you want to delete " + courseName + "?");
	}
</script>
</head>
<body>
<h2>Courses:</h2>

<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Credits</th>
		<th></th>
	</tr>
	<c:forEach items="${courses}" var="course">
		<tr>
			<td>${course.id}</td>
			<td>${course.name}</td>
			<td>${course.credits}</td>
			<td>
				<a href="course/update/${course.id}">Edit</a>
			</td>
			<td>
				<a href="course/delete/${course.id}" onclick="return canDelete('${course.name}');">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
<p/>
<button type="submit" onclick="location.href='addCourse'">Add Course</button>
</body>
</html>