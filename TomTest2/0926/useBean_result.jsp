<%@page import="t0926.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="t0926.Person" id="p" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- useBean_result.jsp --%>
<body>
	<h3>useBean_result.jsp</h3>
	<hr>
	p1 = 이름 :<%= p.getName() %>,
		   나이:<jsp:getProperty property="age" name="p"/>,
		   직업:<jsp:getProperty property="job" name="p"/><br>
	<%
		Person p2 = (Person)request.getAttribute("person");
		Person p3 = (Person)session.getAttribute("person");
	%>
	p2 = 이름 :<%=p2.getName() %>, 나이 :<%=p2.getAge() %>, 직업:<%=p2.getJob() %><br>
	p3 = 이름 :<%=p3.getName() %>, 나이 :<%=p3.getAge() %>, 직업:<%=p3.getJob() %><br>
</body>
</html>