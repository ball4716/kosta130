<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- 1011/empInfo.jsp
	뷰: 컨트롤러에서 저장한 데이터 ==> setAttribute(key,value)를 출력
	==> Attribute(key)
--%>
<body>
	<h3>사원정보(${emp.empno }사번)</h3>
	<hr>
	사원명: ${emp.ename }<br>
	급여: ${emp.sal }<br>
	입사일: ${emp.hiredate }<br>
	부서번호: ${emp.deptno }<br>
	<hr>
	<center>
		<h3>전체 사원 정보</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서번호</th>
			</tr>
			<c:forEach items="${list }" var="em">
				<tr>
					<th>${em.empno }</th>
					<th>${em.ename }</th>
					<th>${em.sal }</th>
					<th>${em.hiredate }</th>
					<th>${em.deptno }</th>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h3>20번 부서의 사원정보(급여 2000이상)</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서번호</th>
			</tr>
			<c:forEach items="${list3 }" var="em">
				<tr>
					<th>${em.empno }</th>
					<th>${em.ename }</th>
					<th>${em.sal }</th>
					<th>${em.hiredate }</th>
					<th>${em.deptno }</th>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h3>20번 부서의 사원정보(급여 2000미만)</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서번호</th>
			</tr>
			<c:forEach items="${list4 }" var="em">
				<tr>
					<th>${em.empno }</th>
					<th>${em.ename }</th>
					<th>${em.sal }</th>
					<th>${em.hiredate }</th>
					<th>${em.deptno }</th>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h3>30번 부서의 사원정보(이름에 'A'가 포함되지 않음)</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서번호</th>
			</tr>
			<c:forEach items="${list5 }" var="em">
				<tr>
					<th>${em.empno }</th>
					<th>${em.ename }</th>
					<th>${em.sal }</th>
					<th>${em.hiredate }</th>
					<th>${em.deptno }</th>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<h3>동적 SQL 테스트</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>급여</th>
				<th>입사일</th>
				<th>부서번호</th>
			</tr>
			<c:forEach items="${listCommon }" var="em">
				<tr>
					<th>${em.empno }</th>
					<th>${em.ename }</th>
					<th>${em.sal }</th>
					<th>${em.hiredate }</th>
					<th>${em.deptno }</th>
				</tr>
			</c:forEach>
		</table>
		<hr>
	</center>
</body>
</html>