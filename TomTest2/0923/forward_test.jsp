<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- forward_test.jsp --%>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		System.out.println(":::::forward_test.jsp(파라미터):"+request.getParameter("name"));
		//forward이동!!
		//application.getRequestDispatcher("이동할 페이지");
		RequestDispatcher dispatcher = application.getRequestDispatcher("/0923/result.jsp");
		
		System.out.println("forward_test.jsp(request객체):"+request);
		
		dispatcher.forward(request, response);
	%>
</body>
</html>