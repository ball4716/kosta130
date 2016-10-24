<%@page import="t0926.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="t0926.Person" id="p" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//Person p = new Person();//useBean액션에서 사용한 변수와 충돌
	Person p2 = new Person("길라임",15,"학생");
	
	Person p3 = new Person();
	p3.setName("김주원");
	p3.setAge(17);
	p3.setJob("학생");
	
	request.setAttribute("person", p2);
	session.setAttribute("person", p3);
	
	p.setName("홍길동");
%>
<jsp:setProperty property="age" name="p" value="13"/>
<jsp:setProperty property="job" name="p" value="학생"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- useBean_test.jsp --%>
<body>
	<h3>useBean액션 테스트</h3>
	<%-- <jsp:forward page="useBean_result.jsp"></jsp:forward>--%>
	<%
		application.getRequestDispatcher("/0926/useBean_result.jsp").forward(request,response);
		//response.sendRedirect("useBean_result.jsp");
	%>
</body>
</html>