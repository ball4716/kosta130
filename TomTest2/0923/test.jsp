<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%
		String name2="김현영";
	%>
	<script type="text/javascript">
		//자바스크립트(브라우저 실행)
		var name1="오정훈";
		//document.write(name2); //자바에서 선언,초기화된 변수 참조X
		document.write('이름2:<%= name2%><hr>');
	</script>
</head>
<%-- test.jsp
	(JSP페이지 실행은 1.자바실행 2.HTML태그실행)
--%>
<body>
	<%
		//자바(JVM실행)
		//out.print(name2); //자바에서 선언,초기화된 변수 출력 O
		//out.print(name1); //자바스크립트에서 선언,초기화된 변수는 절대 출력X
		//이건 변수출력이 아니므로아니다!!
		out.print("<script type='text/javascript'>document.write('이름1:'+name1)</script>");
	%>
</body>
</html>