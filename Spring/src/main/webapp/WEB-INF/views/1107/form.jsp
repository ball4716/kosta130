<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- form.jsp --%>
<body>
	<h3>로그인폼</h3>
	<hr>
	<form action="login4" method="post">
		아이디: <input type="text" name="id">
		비  번: <input type="password" name="pass">
		<input type="submit" value="로그인">
	</form>
</body>
</html>