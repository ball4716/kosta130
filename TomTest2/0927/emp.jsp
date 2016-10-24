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
		<h3>사원정보</h3>
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
			//DB연결작업(1.드라이버 로딩, 2.Connection 3.Statement 4.ResultSet)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			String sql = "select empno,ename,sal,hiredate,dname from emp,dept where emp.deptno=dept.deptno";
			PreparedStatement pstmt = conn.prepareStatement(sql);//DB서버에게 sql전달
			ResultSet rs = pstmt.executeQuery();//조회 시점
			
			while(rs.next()){
		%>
				<tr>
					<td><%= rs.getInt("empno") %></td>
					<td><%= rs.getString("ename") %></td>
					<td><%= rs.getInt("sal") %></td>
					<td><%= rs.getDate("hiredate") %></td>
					<td><%= rs.getString("dname") %></td>
				</tr>
		<%	}%>
		
		</table>
	</center>
</body>
</html>