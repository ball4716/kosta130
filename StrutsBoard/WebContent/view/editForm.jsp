<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="0929/board.css" type="text/css" />
<script type="text/javascript">
	var childWin;
	var state;
	function pass_check(updel){
		childWin = window.open('../view/pass_check.jsp','check','width=250,height=100,top=100,bottom=150');
		state=updel;
	}
	function pass_confirm(){
		childWin.close();
		if(state=='del'){
			var agent = navigator.userAgent.toLowerCase();
			if(confirm('정말삭제하시겠습니까?')){
				if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
					location.href="../guest/control.do?action=delete&id=${guest.id }";
				} else {
					location.href="../guest/control.do?action=delete&id=${guest.id }";
				}
			}
		}else if(state=='up'){
			document.upForm.submit();
			/*
			참고) <form>태그 내의 action값 변경 가능
				document.upForm.action='list.jsp';
			*/
		}
	}
</script>
</head>
<body>
	<div class="header-wrapper">
		<div class="header pagewidth">
			<!-- TITLE -->
			<h1>방명록-수정</h1>
			<h2>당신의 방문을 모두에게 알려주세요</h2>
			<!-- END TITLE -->
		</div>
	</div>
	<form action="control.do?action=update&id=${guest.id }" method="POST" name="upForm">
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
					<h3>수정폼</h3>
					<table>
						<tr>
							<th>작성자</th>
							<td><input type="text" name="name" value="${guest.name }"></td>
						</tr>
						<tr>
							<th>email</th>
							<td><input type="text" name="email" value="${guest.email }"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="tel" value="${guest.tel }"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pass"
								value="${guest.pass }"></td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="contents" rows="10"
									cols="50">${guest.contents }</textarea></td>
						</tr>
						<tr align="center">
							<td colspan="2"><input type="button" value="수정" onclick="pass_check('up')"> <input
								type="reset" value="취소"> <input type="button" value="삭제"
								onclick="pass_check('del')"></td>
						</tr>
					</table>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</form>
</body>
</html>