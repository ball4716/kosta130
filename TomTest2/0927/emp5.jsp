<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h3>사원정보5</h3>
		<hr>
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서명</th>
			</tr>
			<c:forEach items="${list }" var="emp" varStatus="stat">
			<c:if test="${stat.index%2==0 }">
				<tr bgcolor="#dddddd">
			</c:if>
			<c:if test="${stat.index%2!=0 }">
				<tr bgcolor="#ffffff">
			</c:if>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.sal }</td>
					<td>${emp.hiredate }</td>
					<td>${emp.dname }</td>
				</tr>
			</c:forEach>

		</table>
	</center>
</body>
</html>