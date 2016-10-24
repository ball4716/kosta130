<%@page import="t0926.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- print.jsp --%>
<body>
	<h3>JSP기본태그 Expression</h3>
	k1: <%= pageContext.getAttribute("k1") %><br>
	k2: <%= request.getAttribute("k2") %><br>
	k3: <%= session.getAttribute("k3") %><br>
	k4: <%= application.getAttribute("k4") %><br>
	<hr>
	<%
	Person p1 = (Person)request.getAttribute("k5");
	Person p2 = (Person)session.getAttribute("k5");
	Person p3 = (Person)application.getAttribute("k5");
	%>
	request k5: <%= p1.getName() %><br>
	session k5: <%= p2.getName() %><br>
	application k5: <%= p3.getName() %><br>
	<hr>
	<h3>JSP EL(Expression Language)</h3>
	k1: ${k1 }<br>
	k2: ${k2 }<br>
	k3: ${k3 }<br>
	k4: ${k4 }<br>
	<hr>
	<%--
		${a.b}
		===> a : 특정 클래스의 레퍼런트
		===> b : 클래스의 getB()메소드 호출!!
	 --%>
	request k5: ${k5.name }<br>
	<%--
		session.setAttribute("k5",new Person());
		k5: Person의 레퍼런스
		k5.name : getName()
	 --%>
	session k5: ${k5.name }<br>
	application k5: ${k5.name }<br>
	<hr>
	request k5: ${requestScope.k5.name }<br>
	session k5: ${sessionScope.k5.name }<br>
	application k5: ${applicationScope.k5.name }<br>
</body>
</html>