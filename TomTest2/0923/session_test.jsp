<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- session_test.jsp --%>
<body>
	<%
		//session.setMaxInactiveInterval(int second);
		session.setMaxInactiveInterval(5);
		
		if(session.isNew()){//세션이 새로 생성되었다면(브라우저 첫 접속이라면)
			out.print("<script type='text/javascript'>alert('세션이 해제되어 다시 설정합니다!!')</script>");
		}
	%>
	<h3>세션테스트</h3>
	<hr>
	<ol>
		<li>세션 ID(접속한 브라우저에게 부여하는 번호) = <%= session.getId() %></li>
		<li>세선유지시간: <%= session.getMaxInactiveInterval() %> 초</li>
	</ol>
</body>
</html>