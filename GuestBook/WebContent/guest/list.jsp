<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/GuestBook/guest/board.css"
	type="text/css; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="nav-wrapper">
		<div class="nav pagewidth">
			<!-- MENU -->
			<!-- <li><a href="">방명록쓰기</a></li> -->
			<ul>
				<li><html:link action="form.do">글쓰기</html:link></li>
			</ul>
			<!-- END MENU -->
		</div>
	</div>
	<div class="pagewidth">
		<div class="page-wrap">
			<div class="content">

				<!-- CONTENT -->
				<h3>게시판</h3>
				<table>
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>전화번호</th>
						<th>작성일</th>
						<th>내용</th>
					</tr>
					<c:forEach items="${list }" var="guest">
						<tr>
							<td>${guest.id }</td>
							<td>${guest.name }</td>
							<td>${guest.tel }</td>
							<td>${guest.gdate }</td>
							<td><a href="crud.do?action=upform&id=${guest.id }">${guest.contents }</a></td>
						</tr>
					</c:forEach>
				</table>
				<br>
<%-- 				<c:if test="${page == 1 }">
				이전
				</c:if>
				<c:if test="${page > 1 }">
					<a href="control.do?action=list&page=${page-1 }">이전</a>
				</c:if>
				<c:if test="${page == totalPage}">
				다음
				</c:if>
				<c:if test="${page <totalPage }">
					<a href="control.do?action=list&page=${page+1 }">다음</a>
				</c:if>
				<br>
				<c:forEach var="i" begin="1" end="${totalPage }" step="1">
					<c:if test="${i == page }">
						[${i }] 
					</c:if>
					<c:if test="${i != page }">
						<a href="control.do?action=list&page=${i }">[${i }]</a>
					</c:if>
				</c:forEach> --%>
			</div>
		</div>
	</div>
</body>
</html>