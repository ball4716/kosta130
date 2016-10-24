<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- 1010/ibatis_test.jsp --%>
<body>
	<h3>iBatis(sqlMapper프레임워크)테스트</h3>
	<hr>
	<b>부서를 선택하세요!!</b>
	<br>
	<form action="emp.do" method="POST">
		<input type="radio" name="deptNo" value="10" checked> 10번부서
		<input type="radio" name="deptNo" value="20" > 20번부서
		<input type="radio" name="deptNo" value="30" > 30번부서
		<input type="radio" name="deptNo" value="40" > 40번부서
		<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>