<%@page import="java.util.List"%>
<%@page import="iba.SqlMapConfig"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- result.jsp --%>
<body>
	<h3><%=request.getAttribute("deptNo") %>부서의 사원 정보</h3>
	<%
	List<String> list = (List)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){%>
		<%=list.get(i)+"<br>" %>
	<%} %>
	<br>
	<h3>JSTL ${deptNo }부서의 사원 정보</h3>
	<c:forEach var="ename" items="${list }">
		${ename}<br>
	</c:forEach>
</body>
</html>