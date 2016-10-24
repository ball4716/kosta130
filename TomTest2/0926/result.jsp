<%@page import="t0926.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pp" class="t0926.Person"></jsp:useBean>
<%-- <jsp:setProperty property="age" name="pp"/> -->
<%-- pp.setAge( Integer.parseInt( request.getParameter("age")) ); --%>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:setProperty property="*" name="pp"/>
<%-- HTML의 이름과 Bean의 이름이 일치하는 것에 대해 자동 매핑 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- result.jsp --%>
<body>
	<%
		//request.setCharacterEncoding("UTF-8");//post한 글에 대한 처리
	
		/* String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		p.setJob(job); */
	%>
	<h3>전송된 결과</h3>
	이름: <%=pp.getName() %><br>
	나이: <%=pp.getAge() %><br>
	직업: <%=pp.getJob() %><br>
	<hr>
	<h3>EL을 통한 데이터 얻기</h3>
	이름: <%= request.getParameter("name") %><br>
	나이: ${param.age }<br>
	직업: ${param.job }<br>
	길동파라미터: <%= request.getParameter("gildong") %><br><!-- null -->
	라임파라미터: ${param.lime }<br><!-- 빈문자열 -->
</body>
</html>