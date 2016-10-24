<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- end.jsp --%>
<body>
	<h3>end.jsp(영역에 저장된 데이터 출력)</h3>
	<hr>
	k1: <%= pageContext.getAttribute("k1") %><br>
	k2: <%= request.getAttribute("k2") %><br>
	k3: <%= session.getAttribute("k3") %><br>
	k4: <%= application.getAttribute("k4") %><br>
</body>
</html>