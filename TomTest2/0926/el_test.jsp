<%@page import="t0926.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- el_test.jsp --%>
<body>
	<h3>Expression Language(EL): 데이터 저장</h3>
	<hr>
	<%
		pageContext.setAttribute("k1", "홍길동");
		request.setAttribute("k2", "길라임");
		session.setAttribute("k3", "김주원");
		application.setAttribute("k4", "이순신");
		
		Person p1 = new Person("김유신1", 16, "화랑");
		Person p2 = new Person("김유신2", 16, "화랑");
		Person p3 = new Person("김유신3", 16, "화랑");
		
		request.setAttribute("k5",p1);
		session.setAttribute("k5",p2);
		application.setAttribute("k5", p3);
		
		//페이지 이동
		RequestDispatcher dispatcher = application.getRequestDispatcher("/0926/print.jsp");
		dispatcher.forward(request,response);
	%>
	<form action="print2.jsp" method="post">
		이름: <input type="text" name="name"><br>
		나이: <input type="text" name="age"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>