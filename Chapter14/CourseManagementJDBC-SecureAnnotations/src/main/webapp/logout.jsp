<%@ page session="true"%>

Logged out <%=request.getRemoteUser()%>

<% session.invalidate(); %>

