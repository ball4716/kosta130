<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
</head>
<%-- 1006/login_form.jsp --%>
<body>
	<h3>로그인 폼</h3>
	<hr>
	<%--if(session.getAttribute("info") == null){} --%>
	<logic:notPresent scope="session" name="info">
		<b>로그인하세요</b>
	</logic:notPresent>
	
	
	<logic:present scope="session" name="info">
		<b>로그인되었습니다</b>
		<h4>사용자 정보</h4>
		이름: <bean:write scope="session" name="info" property="name"/><br>
		전화번호: <bean:write scope="session" name="info" property="phone"/><br>
		이메일: ${info.email }<br>
		<a href="logout.do">로그아웃</a><br>
		<html:link action="/login2/logout">로그아웃</html:link>
	</logic:present>
	
	<html:messages message="true" id="m">
		<font color="blue"><bean:write name="m"/></font><br>
	</html:messages>
	
	<!-- <form action="login.do" method="post" -->
	<html:form action="/login2/login" method="post" focus="userid">
		아이디: <!-- <input type="text" name="userid"> -->
				<html:text property="userid"/>
				
				<%-- ActionErrors에 errorid키값이 저장되어있다면
				키값에 저장되어 있는 메시지를 출력 --%>
				<html:messages property="errorid" id="msg">
					<font color="red">
						<bean:write name="msg"/>
					</font>
				</html:messages>
				<br>
		비밀번호: <!-- <input type="password" name="userpwd"> -->
				<html:password property="userpwd" redisplay="false"/>
				<html:messages property="errorpwd" id="v">
					<font color="red"><bean:write name="v"/></font>
				</html:messages>
				<br>
		<!-- <input type="submit" value="로그인"> -->
		<html:submit value="로그인"/> <html:reset value="취소"/>
	</html:form>
</body>
</html>