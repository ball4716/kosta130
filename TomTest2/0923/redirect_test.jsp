<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- redirect_test.jsp --%>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		System.out.println(":::::redirect_test.jsp(파라미터):"+request.getParameter("name"));
		//리다이렉트 이동(현페이지 ---> result.jsp)
		//response.sendRedirect("이동할 페이지 경로");
		System.out.println("redirect_test.jsp(request객체):"+request);
		response.sendRedirect("result.jsp");
		//리다이렉트 이동시에는 이동하는 result.jsp에게 request정보를 전달하지 않는다!!
	%>
</body>
</html>