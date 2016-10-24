<%@page import="java.util.ArrayList"%>
<%@page import="t0926.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- test.jsp (JSTL -foreach) --%>
<body>
<%
	String subject[]={"자바","SQL","JDBC","HTML","JSP"};

	List<Person> list = new ArrayList<>();
	list.add(new Person("길동",13,"학생"));
	list.add(new Person("라임",14,"학생"));
	list.add(new Person("주원",15,"학생"));
	
	request.setAttribute("subject", subject);
	request.setAttribute("li", list);
%>

<h3>배열데이터 출력</h3>
<c:forEach items="${subject }" var="sub">
${sub }<br>
</c:forEach>
<hr>
<h3>리스트데이터 출력</h3>
<c:forEach items="${li }" var="p" varStatus="vs">
	이름: ${p.name }, 나이: ${p.age }, INDEX: ${vs.index }, test: ${p.test }<br>
</c:forEach>
</body>
</html>