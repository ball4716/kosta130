<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- login.jsp(로그인화면) --%>
<body>
	<h3>로그인</h3>
	<hr>
	<form action="selProduct.jsp" method="post">
		사용자 이름: <input type="text" name="username">
		<input type="submit" value="로그인">
	</form>
</body>
</html>