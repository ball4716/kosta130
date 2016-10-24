<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- result2.jsp -->
<body>
	<h3>결과페이지</h3>
	<hr>
	<b>전달받은 데이터</b>
	<% request.setCharacterEncoding("UTF-8"); %>
	<ul>
		<li>이름: <%= request.getParameter("name") %></li>
		<li>비밀번호: <%= request.getParameter("pass") %></li>
		<li>히든: <%= request.getParameter("hdata") %></li>
		<li>
		과일:
		<%
			String[] fruits = request.getParameterValues("fruit");
			String choiceFruit = "";
			for(int i=0;i<fruits.length; i++){
				choiceFruit+=fruits[i]+" ";
			}
		%>
		<%= choiceFruit %>
		</li>
		<li>강의실: <%= request.getParameter("room") %></li>
		<li>식사: <%= request.getParameter("dinner") %></li>
		<li>코멘트: <%= request.getParameter("comment") %></li>
	</ul>
	<hr>
	<%
		Enumeration<String> enu = request.getParameterNames();
		//HTML폼 내의 name값 얻어오기
		
		while(enu.hasMoreElements()){
			String name = enu.nextElement();
			out.print(name+":"+request.getParameter(name)+"<br>");
		}
		
		out.print("<hr color='red'>");
		Map<String,String[]> map = request.getParameterMap();
		//out.print("<hr>"+map);
		
		Set<String> set = map.keySet();
		
		Object keys[] = set.toArray();
		for(int i=0; i<keys.length; i++){
			String data[] = map.get(keys[i]);
			out.print(keys[i]+" : ");
			for(int j=0; j<data.length; j++){
				out.print(data[j]);
			}
			out.print("<br>");
		}
	%>
</body>
</html>