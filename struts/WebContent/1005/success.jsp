<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- success.jsp --%>
<body>
	<h3>로그인 성공</h3>
	<hr>
	<b>로그인에 성공하셨습니다.</b><br>
	이름: ${info.name } <br>
	전화번호: ${info.phone } <br>
	이메일: ${info.email } <br>
</body>
</html>