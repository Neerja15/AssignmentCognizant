<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

session.setMaxInactiveInterval(20);
%>
<!-- com.cts.bean.LoginBean ref = new LoginBean() -->
<jsp:useBean id="ref" class="com.cts.bean.LoginBean" scope="session"/>
<!-- ref.setUserName(request.getParameter("userName")) -->
<%-- <jsp:setProperty property="userName" name="ref"/>
<!-- ref.setUserName(request.getParameter("password")) -->
<jsp:setProperty property="password" name="ref"/> --%>

<jsp:setProperty property="*" name="ref"/>
<jsp:forward page="view.jsp"></jsp:forward>

</body>
</html>