<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="0929/board.css" type="text/css" />
<script type="text/javascript">
<%-- 	function passCheck(id){
		//window.open('confirmid.jsp?id='+document.frm.id.value,'confirm','width=400,height=300,left=300,right=300');
		window.open('confirmid_form.jsp?id='+id,'confirm','width=400,height=300,left=300,right=300');
	} --%>
</script>
</head>
<body>
<center>
	<div class="header-wrapper">
		<div class="header pagewidth">
			<!-- TITLE -->
			<h1>방명록</h1>
			<h2>당신의 방문을 모두에게 알려주세요</h2>
			<!-- END TITLE -->
		</div>
	</div>
	<div class="nav-wrapper">
		<div class="nav pagewidth">
			<ul>
				<!-- MENU -->
				<li><a href="control?action=inputForm">방명록 쓰기</a></li>
				<!-- END MENU -->
			</ul>
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
					<c:forEach items="${list }" var="guest" varStatus="stat">
						<tr>
							<td>${guest.id }</td>
							<td>${guest.name }</td>
							<td>${guest.tel }</td>
							<td>${guest.gdate }</td>
							<td><a href="#" onclick="location.replace('control?action=edit&id='+${guest.id })">${guest.contents }</a></td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<c:if test="${page == 1 }">
				이전
				</c:if><c:if test="${page > 1 }">
					<a href="control?action=list&page=${page-1 }">이전</a>
				</c:if>
				<c:if test="${page == totalPage}">
				다음
				</c:if><c:if test="${page <totalPage }">
				<a href="control?action=list&page=${page+1 }">다음</a>
				</c:if>
				<br>
				<c:forEach var="i" begin="1" end="${totalPage }" step="1">
					<c:if test="${i == page }">
						[${i }] 
					</c:if>
					<c:if test="${i != page }">
						<a href="control?action=list&page=${i }">[${i }]</a> 
					</c:if>
				</c:forEach>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	</center>
</body>
</html>