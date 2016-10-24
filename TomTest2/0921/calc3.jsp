<%@page import="t0921.Calculator"%>
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
		<form method='post'>
			<input type='text' size='4' name='su1'> <select name='oper'>
				<option>+</option>
				<option>-</option>
				<option>*</option>
				<option>/</option>
			</select> <input type='text' size='4' name='su2'> <input type='submit'
				value='계산'><br>
		</form>

		<%
			String method = request.getMethod();
			if (method.equals("POST")) {
				String su1 = request.getParameter("su1");
				String su2 = request.getParameter("su2");
				String oper = request.getParameter("oper");
		%>	
		<br><hr>
		<%
				//유효성 검사
				if (su1.length() == 0 || su2.equals("")) {%>
					<font color='red'>데이터를 입력!!</font>
				<% } else if (!(su1.matches("[0-9]+") || su2.matches("[0-9]+"))) {%>
					<font color='red'>숫자만 입력!!</font>"
				<% } else if (oper.equals("/") && su2.equals("0")) {%>
					<font color='red'>0으로 나눌 수 없습니다!!</font>
				<% } else {
					Calculator cal = new Calculator(Integer.parseInt(su1), Integer.parseInt(su2), oper);
					String result = cal.getResult();%>
					<font color='blue'><%= cal.getResult() %></font>
				<% }
			}
		%>
	</center>
</body>
</html>