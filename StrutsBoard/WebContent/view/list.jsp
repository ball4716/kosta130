<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<div class="nav-wrapper">
	<div class="nav pagewidth">
		<!-- MENU -->
		<!-- <li><a href="">방명록쓰기</a></li> -->
		<ul>
		<li>
		<html:link action="/guest/input">글쓰기</html:link>
		</li>
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
					<c:forEach items="${list }" var="guest" varStatus="stat">
						<tr>
							<td>${guest.id }</td>
							<td>${guest.name }</td>
							<td>${guest.tel }</td>
							<td>${guest.gdate }</td>
							<td><a href="#" onclick="location.replace('control.do?action=edit&id='+${guest.id })">${guest.contents }</a></td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<c:if test="${page == 1 }">
				이전
				</c:if><c:if test="${page > 1 }">
					<a href="control.do?action=list&page=${page-1 }">이전</a>
				</c:if>
				<c:if test="${page == totalPage}">
				다음
				</c:if><c:if test="${page <totalPage }">
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
				</c:forEach>
			</div>
		</div>
</div>