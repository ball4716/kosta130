<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- base.jsp(레이아웃 설정페이지)==> table,div --%>
<body>
	<h3>TilesFramework</h3>
	<hr>
	<table width="100%" border="1">
		<tr>
			<td colspan="2" align="center">
				<%-- <%@include file="header.jsp" %> --%>
				<tiles:insert attribute="header" />
			</td>
		</tr>
		<tr>
			<td width="100"><tiles:insert attribute="menu" /></td>
			<td><tiles:insert attribute="body" /></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insert attribute="footer" /></td>
		</tr>
	</table>
</body>
</html>