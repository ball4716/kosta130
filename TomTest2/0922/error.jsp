<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- error.jsp(JSP페이지에서 에러가 발생시 공통적으로 화면 표시할 페이지) --%>
<body>
	<center>
		<table>
			<tr>
				<td><b>페이지에러발생:<%= exception.getMessage() %></b></td>
			</tr>
			<tr>
				<td bgcolor="black" style="color:red">
				☠죄송합니다.☠<br>
				☠잠시후에 다시 접속해주세요.☠<br>
				☠문제가 계속 발생시☠<br>
				☠관리자에게 문의 바랍니다.☠<br>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>