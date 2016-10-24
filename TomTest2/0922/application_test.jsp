<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- application_test.jsp --%>
<body>
	<h3>application(ServletContext)객체 테스트</h3>
	<hr>
	1. 서블릿 컨테이너 이름 : <%= application.getServerInfo() %> <br>
	2. 서블릿 API버전 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
	3. 현재 Context(TomTest2)의 하드디스크 실제 경로: <%= application.getRealPath("") %><br>
	
	<%
		//클라이언트 접속 정보를 얻어서 기록파일을 남겨보기!!
		String protocol = request.getProtocol();//HTTP요청 버전: 1.0, 1.1
		String addr = request.getRemoteAddr();//접속ip
		String method = request.getMethod();//요청방식
		
		String msg = "[접속한 클라이언트정보]<br>protocol : "+protocol
		+"<br>접속IP : "+addr+"<br>요청방식 : "+method+"<br>" + new Date();
		
		System.out.println(msg);//서버 콘솔화면 출력
		out.print(msg);//브라우저 출력
		application.log(msg);//text파일을 logs폴더에 출력
	%>
</body>
</html>