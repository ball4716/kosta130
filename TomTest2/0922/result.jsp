<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- result.jsp(결과페이지) --%>
<body>
	<h3>결과페이지</h3>
	<hr>
	<%
		//request(요청객체) - 요청페이지(input.jsp)
		request.setCharacterEncoding("UTF-8");//요청페이지에서 전달된 한글에 대한 처리
		//※주의: form method="post" 즉, post요청방식에만 적용됨!!
		
		String name = request.getParameter("name"); %>
	입력된 값 출력: <%= name %>
</body>
</html>