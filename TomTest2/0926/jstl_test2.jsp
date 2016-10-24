<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- jstl_test2.jsp --%>
<body>
	<%  %>
	<h3>JSTL태그 테스트</h3>
	<hr>
	<c:if test="true">
		true테스트(무조건실행)<br>
	</c:if>
	<c:if test="some text">
		some text(무조건 실행 안함!!)<br>
	</c:if>
	<% request.setCharacterEncoding("UTF-8"); %>
	<c:if test="${param.age > 19 && param.age < 30}">
		<font color="red">${param.name }님은 20대입니다</font>	
	</c:if>
	<c:if test="${param.age > 29 && param.age < 40}">
		<font color="blue">${param.name }님은 30대입니다</font>	
	</c:if>
	<hr>
	<h3>choose~when문</h3>
	<c:choose>
		<c:when test="${param.age < 30}">
			<font color="red">${param.name }님은 20대입니다</font>	
		</c:when>
		<c:when test="${param.age < 40}">
			<font color="blue">${param.name }님은 30대입니다</font>	
		</c:when>
		<c:otherwise>
			${param.name }님은 20대,30대가 아닙니다!
		</c:otherwise>
	</c:choose>
	<hr>
	<h3>for문</h3>
	<c:forEach var="i" begin="1" end="10" step="2" varStatus="stat">
		${i }: 실행된 횟수: ${stat.count }, ${stat.index }<br>
	</c:forEach>
</body>
</html>