<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="1kb"
    autoFlush="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- out_test.jsp --%>
<body>
	<h3>출력테스트</h3>
	<%
		for(int i=0; i<716; i++){
			out.print(0);
		}
	%>
	<hr>
	출력버퍼크기: <%= out.getBufferSize() %> byte <br>
	남아있는 버퍼사이즈: <%= out.getRemaining() %> <br>
</body>
</html>