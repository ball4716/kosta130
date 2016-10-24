<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 0921/first.jsp -->
<body>
	<%!
		//자바코드
		int su;
			//su10; 에러발생: 변수초기화 X
		String name="홍길동";
		
		public String getMsg(){
			return "나는 네가 추석에 어떤일을 했는지 알고있다!!";
		}
	%>
	
	<%
		//자바코드
		String name2;
			   name2="길라임";
		su = 13;
		int su2=14;
		if(su<su2){
			System.out.print("su2는 su2보다 작다");//서버 콘솔 출력
			out.print("[su2는 su2보다 작다]<br>");//브라우저 출력
		}
		String msg = getMsg();
		out.print("MSG: "+msg+"<br>");
	%>
	
	<%= "안녕, JSP" %><br>
	SU2: <%= su2 %><br>
	MSG출력: <%= getMsg() %><br>
	<!-- 나주석(HTML) -->
	<%-- 나도주석(JSP) --%>
	
	<!-- <%= new Date() %> -->
	<%-- <%= new Date() %> --%>
</body>
</html>