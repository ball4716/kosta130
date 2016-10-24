<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- dbcp_test.jsp (dbcp,datasource) --%>
<body>
	<h3>DBCP테스트(DataBase Connection Pool)</h3>
	<hr>
	<%
		Context ctx = new InitialContext();
		Context tomCtx = (Context)ctx.lookup("java:comp/env");
		//톰켓이 제공하는 Context 얻어오기
		DataSource ds = (DataSource)tomCtx.lookup("jdbc/oracle");
		//톰켓서버 내부에 등록되어 있는 객체 얻어오기
		//ds == 커넥션 Pool
		
		Connection conn = ds.getConnection();
		
		out.print("DB연결 성공!!");
	%>
</body>
</html>