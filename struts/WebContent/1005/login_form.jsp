<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
</head>
<%-- 1005/login_form.jsp --%>
<body>
	<h3>로그인 폼</h3>
	<hr>
	<form action="login.do">
		아이디: <input type="text" name="userid"><br>
		비밀번호: <input type="password" name="userpwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>