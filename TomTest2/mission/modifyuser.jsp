<%@page import="t0927.UserInfo"%>
<%@page import="t0927.UserInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자수정</title>
<%-- modifyuser.jsp(수정폼) --%>
<%
	String id = (String) session.getAttribute("loginID");
	UserInfoDao dao = new UserInfoDao();
	UserInfo user = dao.select(id);
%>
</head>
<body>
	<center>
		<form name="frm" action="modifyprocess.jsp" method="post">
			<table width="600" border="0" cellpadding="5">
				<tr bgcolor="#3399cc">
					<td><font size="4" color="white">사용자정보수정</font>
				</tr>
			</table>
			<table border="1" cellpadding="5" width="600">
				<tr>
					<td width="100" bgcolor="#ffcccc">사용자ID</td>
					<td colspan="3">
						<input type="text" name="id" value="<%=user.getId()%>" disabled>
						<input type="hidden" name="id" value="<%=user.getId()%>">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">비밀번호</td>
					<td>
						<input type="password" name="pass" value="<%=user.getPass()%>">
					</td>
					<td width="100" bgcolor="#ffcccc">비번확인</td>
					<td>
					<input type="password" name="pass2" value="<%=user.getPass()%>">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">사용자이름</td>
					<td colspan="3"><input type="text" name="name"
						value="<%=user.getName()%>" disabled></td>

				</tr>
				<tr>
					<%
						String jumin[] = user.getJumin().split("-");
						String birth[] = user.getBirth().split("-");
						String zip[] = user.getZip().split("-");
					%>
					<td width="100" bgcolor="#ffcccc">주민번호</td>
					<td colspan="3"><input type="text" name="jumin1" size="6"
						maxlength="6" style="height: 23px" value="<%=jumin[0]%>" readonly>
						- <input type="password" name="jumin2" size="7" maxlength="7"
						style="height: 23px" value="<%=jumin[1]%>" readonly></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">생년월일</td>
					<td colspan="3"><input type="text" name="year" size="4"
						maxlength="4" value="<%=birth[0]%>" disabled>년 <select
						name="month" disabled>
							<option><%=birth[1]%></option>
					</select>월 <select name="day" disabled>
							<option><%=birth[2]%></option>
					</select>일</td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">우편번호</td>
					<td colspan="3"><input type="text" name="zip1" size="3"
						maxlength="3" value="<%=zip[0]%>"> - <input type="text"
						name="zip2" size="3" maxlength="3" value="<%=zip[1]%>"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">주소</td>
					<td colspan="3"><input type="text" name="addr" size="50"
						value="<%=user.getAddr()%>"></td>
				</tr>
				<tr>
					<td width="100" bgcolor="#ffcccc">E-Mail</td>
					<td colspan="3"><input type="text" name="email" size="30"
						value="<%=user.getEmail()%>"></td>
				</tr>

				<tr>
					<td width="100" bgcolor="#ffcccc">직업</td>
					<td colspan="3"><select name="job">
							<%
								String jobs[] = { "==선택==", "학생", "공무원", "언론/출판", "군인/경찰", "일반사무직", "영업직", "기술/전문직", "보건/의료", "자영업", "주부",
										"기타" };
								String job = user.getJob();
								for (int i = 0; i < jobs.length; i++) {
									if (job.equals(jobs[i])) {
							%>
							<option value="<%=jobs[i]%>" selected><%=jobs[i]%></option>
							<%
								} else {
							%>
							<option value="<%=jobs[i]%>"><%=jobs[i]%></option>
							<%
								}
								}
							%>
					</select></td>
				</tr>
				<tr align="center">
					<td colspan="4"><input type="submit" value="수정"> <input
						type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>