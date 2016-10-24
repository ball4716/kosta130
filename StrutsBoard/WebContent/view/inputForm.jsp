<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="view/board.css" type="text/css" />
<form action="control.do?action=insert" method="POST">
	<div class="nav-wrapper">
		<div class="nav pagewidth">
			<ul>
				<!-- MENU -->
				<li><a href="control.do?action=list">게시물 목록으로</a></li>
				<!-- END MENU -->
			</ul>
		</div>
	</div>
	<div class="pagewidth">
		<div class="page-wrap">
			<div class="content">

				<!-- CONTENT -->
				<h3>입력폼</h3>
				<table>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>email</th>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="tel"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="contents" rows="10" cols="50"></textarea></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="등록"> <input
							type="reset" value="취소"></td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</form>