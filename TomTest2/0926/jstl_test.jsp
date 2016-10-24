<%@page import="t0926.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- jstl_test.jsp --%>
<body>
	<h3>JSTL테스트</h3>
	<hr>
	<%-- <set>태그: 변수를 정의 --%>
	<%-- <c:set var="변수명" value="데이터" scope="영역"></c:set> --%>
	<c:set var="name" value="나길동" scope="request"></c:set>
	<c:set var="name" value="너길동" scope="session" />
	<c:remove var="name" scope="request"/>
	이름: ${name }<br>
	<% Person p = new Person(); %>
	<c:set target="<%= p %>" property="name" value="길라임"></c:set>
	사람이름: <%= p.getName() %>
</body>
</html>