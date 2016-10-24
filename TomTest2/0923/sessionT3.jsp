<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Session인증자 페이지</title>
<style type="text/css">
<!--
.normal {
	font-family: "굴림", "돋움";
	font-size: x-small;
	font-style: normal;
	font-weight: normal;
	text-decoration: none
}

.normalbold {
	font-family: "굴림", "돋움";
	font-size: x-small;
	font-style: normal;
	font-weight: bold;
	text-decoration: none
}
-->
</style>
</head>

<body>
	<%
		String login = (String)session.getAttribute("login");
		if(login==null || !login.equals("success"))
			response.sendRedirect("sessionT1.jsp");
	%>
	<center>
		<p>
			<!-- <img src="../image/moon.jpg" width="300" height="400"> -->
			<img src="/TomTest2/image/moon.jpg" width="300" height="400">
		</p>
		<p class="normalbold">이 페이지는 사용자 인증을 받아야 볼 수 있죠!</p>
		<p class="normal">감사합니다....</p>
		<p class="normal"><a href="sessionT4.jsp">로그아웃</a></p>
	</center>
</body>
</html>










