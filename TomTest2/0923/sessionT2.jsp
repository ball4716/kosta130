<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 인증</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
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
</style>
</head>
<%-- sessionT2.jsp --%>

<body>
	<center>
		<%
	   		//<DataBase>
			String did = "gildong";
			String dpass = "1234";
			
			//HTML폼데이터 얻어오기
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			if( !id.equals(did) || !pass.equals(dpass) ){
				//입력된 아이디와 비번이 DB와 하나라도 일치하지 않는다면!!
				//----> 인증실패!!
				response.sendRedirect("sessionT1.jsp");
			}else{//아이디와 비번이 일치---->
				session.setAttribute("login", "success");
			}
		%>
		<p class="normalbold">사용자 인증 완료</p>
		<p class="normal"><a href="sessionT3.jsp">서비스페이지</a></p>
	</center>

</body>
</html>










