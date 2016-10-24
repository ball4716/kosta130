<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- pageMove_test.jsp --%>
<body>
	<h3>페이지 이동 테스트</h3>
	<hr>
	<form method="post" action="forward_test.jsp">
		이름: <input type="text" name="name"><br>
		<input type='submit' value="forward이동">
	</form>
	<%-------------------------------------------------%>
	<hr>
	<form method="post" action="redirect_test.jsp">
		이름: <input type="text" name="name"><br>
		<input type='submit' value="redirect이동">
	</form>
	<%
	System.out.println("pageMove_test.jsp(request객체):"+request);
	%>
</body>
</html>