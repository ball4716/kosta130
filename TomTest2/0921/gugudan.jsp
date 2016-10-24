<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 구구단</title>
</head>
<body>
	<center>
	<h3>구구단 출력</h3>
	<table border='1' cellpadding='5'>
		<% for(int i=1; i<10; i++){ %>
			<tr>
			<% for(int j=2; j<10; j++){ %>
				<td><%= j+"*"+i+"="+j*i+"   "%></td>
			<% } %>
			</tr>
		<% } %>
	</table>
	</center>
</body>
</html>