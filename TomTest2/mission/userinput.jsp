<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자등록</title>
<script type="text/javascript">
		function idCheck(){
			//window.open('confirmid.jsp?id='+document.frm.id.value,'confirm','width=400,height=300,left=300,right=300');
			window.open('confirmid_form.jsp','confirm','width=400,height=300,left=300,right=300');
		}
	</script>
</head>
<%-- userinput.jsp --%>
<body>
	<center>
		<form name="frm" action="userprocess.jsp" method="post">
			<table width="600" border="0" cellpadding="5">
				<tr bgcolor="#3399cc">
					<td><font size="4" color="white">사용자정보입력</font>
				</tr>
				<tr>
					<td>안녕하세요. 이 페이지를 자유롭게 이용하려면 먼저 회원가입을 하셔야 합니다.<br> 아래의
						사항들을 빠짐없이 기록해 주세요.
					</td>
				</tr>
			</table>
			<table border="1" cellpadding="5" width="600">
				<tr>
					<td width="100" bgcolor="#ffcccc">사용자ID<font color="red">*</font></td>
					<td colspan="3">
						<input type="text" name="id" readonly onclick="idCheck()">
						<input type="button" value="중복확인" onclick="idCheck()">
						<font color="blue">(6자리~12자리)</font>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">비밀번호<font color="red">*</font></td>
					<td><input type="password" name="pass"></td>
					<td width="100" bgcolor="#ffcccc">비번확인</td>
					<td><input type="password" name="pass2"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">사용자이름<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">주민번호<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="jumin1" size="6"
						maxlength="6" style="height: 23px"> - <input
						type="password" name="jumin2" size="7" maxlength="7"
						style="height: 23px"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">생년월일</td>
					<td colspan="3"><input type="text" name="year" size="4"
						maxlength="4">년 <select name="month">
							<option>--</option>
							<%
								for (int i = 1; i < 13; i++) {
							%>
							<option>
								<%
									if (i < 10)
											out.print("0" + i);
										else
											out.print(i);
								%>
							</option>
							<%
								}
							%>
					</select>월 <select name="day">
							<option>--</option>
							<%
								int[] day = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
										27, 28, 29, 30, 31 };
							%>
							<%
								for (int i = 0; i < day.length; i++) {
							%>
							<option>
								<%=day[i]%>
							</option>
							<%
								}
							%>
					</select>일</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">우편번호<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="zip1" size="3"
						maxlength="3"> - <input type="text" name="zip2" size="3"
						maxlength="3"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">주소</td>
					<td colspan="3"><input type="text" name="addr" size="50"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">E-Mail<font color="red">*</font></td>
					<td colspan="3"><input type="text" name="email" size="30"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">직업<font color="red">*</font></td>
					<td colspan="3"><select name="job">
							<%
								String jobs[] = { "==선택==", "학생", "공무원", "언론/출판", "군인/경찰", "일반사무직", "영업직", "기술/전문직", "보건/의료", "자영업", "주부",
										"기타" };
								for (int i = 0; i < jobs.length; i++) {
							%>
							<option>
								<%=jobs[i]%>
							</option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr align="center">
					<td colspan="4"><input type="submit" value="등록"> <input
						type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>