<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- calc.jsp -->
<body>
	<center>
		<h3>JSP계산기</h3>
		<hr>
		<form action='result.jsp' method='post'>
			<input type='text' size='4' name='su1'>
			<select name='oper'>
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select>
			<input type='text' size='4' name='su2'>
			<input type='submit' value='계산'>
		</form>
	</center>
</body>
</html>