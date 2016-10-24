<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- confirmid_form.jsp --%>
<body>
	<center>
		<form action="confirmid2.jsp">
		<table cellpadding="5">
			<tr>
				<td bgcolor="#33ffcc">아이디: </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="중복확인">
				</td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>