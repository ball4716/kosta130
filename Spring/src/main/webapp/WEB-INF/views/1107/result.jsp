<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- 1107/result.jsp --%>
<body>
	<h3>결과페이지</h3>
	<hr>
	<h4>사용자 정보</h4>
	이름:${user.name }<br>
	전화번호:${user.phone }<br>
	이메일:${user.email }<br>
	${msg }
	
	
</body>
</html>