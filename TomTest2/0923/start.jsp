<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>start.jsp(데이터를 영역에 저장!!)</h3>
	<%
		//데이터 저장(영역!!)
		//pageContext.setAttribute(String key, Object value);
		pageContext.setAttribute("k1(pageContext)", "윤철");
		request.setAttribute("k2(request)", "최예나");
		session.setAttribute("k3(session)", "기호창");
		application.setAttribute("k4(application)", "이대원");
		
		System.out.println("k1에 저장된 값="+pageContext.getAttribute("k1"));
		
		//포워드 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("end.jsp");
									//application.getRequestDispatcher("/0923/end.jsp");
		//dispatcher.forward(request,response);
		
		//리다이렉트 이동
		response.sendRedirect("end.jsp");
	%>
</body>
</html>