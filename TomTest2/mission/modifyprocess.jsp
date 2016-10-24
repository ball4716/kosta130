<%@page import="java.sql.SQLException"%>
<%@page import="t0927.UserInfoDao"%>
<%@page import="t0927.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String zip = request.getParameter("zip1") + "-" + request.getParameter("zip2");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			String job = request.getParameter("job");

			UserInfo user = new UserInfo();
			user.setId(id);
			user.setPass(pass);
			user.setZip(zip);
			user.setAddr(addr);
			user.setEmail(email);
			user.setJob(job);

			UserInfoDao dao = new UserInfoDao();
			try {
				if (dao.update(user)) {
		%>
		<table width="280" border="0" cellpadding="5">
			<tr bgcolor="#3399cc">
				<td><b>수정성공</b></td>
			</tr>
			<tr>
				<td>수정이 잘되었습니다<br> <br> <a href="service.jsp">서비스페이지</a>
				</td>
			</tr>
		</table>
		<%
			} else {
		%>
		<table width="280" border="0" cellpadding="5">
			<tr bgcolor="#3399cc">
				<td><b>수정실패</b></td>
			</tr>
			<tr>
				<td>정보수정이 되지않았습니다.<br> 입력내용을 다시확인하시고 다시수정하시기 바랍니다.<br>
					<br> <a href="javascript:history.go(-1)">이전화면</a>
				</td>
			</tr>
		</table>
		<%
			} //else
			} catch (SQLException e) {
		%>
		<table width="280" border="0" cellpadding="5">
			<tr bgcolor="#3399cc">
				<td><b>수정실패(DB)</b></td>
			</tr>
			<tr>
				<td>정보수정이 되지않았습니다.<br> 입력내용을 다시확인하시고 다시수정하시기 바랍니다.<br>
					입력이 정확한 경우에도 수정이 되지 않는 경우 관리자에게 문의하여 주십시요. <br> <br> <a
					href="javascript:history.back(0)">이전화면</a>
				</td>
			</tr>
		</table>
		<%
			}
		%>
	</center>
</body>
</html>







