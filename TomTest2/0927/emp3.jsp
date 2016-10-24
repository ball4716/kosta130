<%@page import="t0927.Emp"%>
<%@page import="java.util.List"%>
<%@page import="t0927.EmpDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%--
	emp.jsp
	문제) 사원번호, 사원명, 급여, 입사일, 부서명을 출력하시오
 --%>
<body>
	<center>
		<h3>사원정보3</h3>
		<hr>
		<table border="1" cellpadding="5">
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서명</th>
			</tr>
		<%
			List<Emp> list = (List<Emp>)request.getAttribute("list");
			
			for(int i=0; i<list.size(); i++){//List인덱스
				Emp emp = list.get(i);
		%>
				<tr>
					<td><%= emp.getEmpno() %></td>
					<td><%= emp.getEname() %></td>
					<td><%= emp.getSal() %></td>
					<td><%= emp.getHiredate() %></td>
					<td><%= emp.getDname() %></td>
				</tr>
		<%	}%>
		
		</table>
	</center>
</body>
</html>