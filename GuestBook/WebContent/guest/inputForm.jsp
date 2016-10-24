<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/GuestBook/guest/board.css"
	type="text/css; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="crud.do?action=insert" method="POST">
		<div class="nav-wrapper">
			<div class="nav pagewidth">
				<ul>
					<!-- MENU -->
					<li><a href="list.do">게시물 목록으로</a></li>
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
							<td colspan="2"><textarea name="contents" rows="10"
									cols="50"></textarea></td>
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
</body>
</html>