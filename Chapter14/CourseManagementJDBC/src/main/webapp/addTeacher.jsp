<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Teacher</title>
</head>
<body>
	<c:set var="errMsg" value="${null}"/>
	<c:set var="displayForm" value="${true}"/>
	<c:if test="${\"POST\".equalsIgnoreCase(pageContext.request.method) 
				&& pageContext.request.getParameter(\"submit\") != null}">
		<jsp:useBean id="teacherBean" class="packt.book.jee.eclipse.ch4.bean.Teacher">
			<c:catch var="beanStorageException">
				<jsp:setProperty name="teacherBean" property="*" />
			</c:catch>
		</jsp:useBean>
		<c:choose>
			<c:when test="${!teacherBean.isValidTeacher() || beanStorageException != null}">
				<c:set var="errMsg" value="Invalid teacher details. Please try again"/>
			</c:when>
			<c:otherwise>
				<c:catch var="addTeacherException">
					${teacherBean.addTeacher()}
				</c:catch>
				<c:choose>
					<c:when test="${addTeacherException != null}">
						<c:set var="errMsg" value="${addTeacherException.message}"/>
					</c:when>
					<c:otherwise>
						<c:redirect url="listTeacher.jsp"/>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</c:if>

	<h2>Add Teacher:</h2>
	<c:if test="${errMsg != null}">
		<span style="color: red;">
			<c:out value="${errMsg}"></c:out>
		</span>
	</c:if>
	<form method="post">
		First Name: <input type="text" name="firstName"> <br>
		Last Name: <input type="text" name="lastName"> <br>
		Designation : <input type="text" name="designation"> <br>
		<button type="submit" name="submit">Add</button>
	</form>

</body>
</html>