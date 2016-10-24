<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- my_form.jsp --%>
<body>
	<h3>ActionForm, Action테스트</h3>
	<hr>
	<form method="post" action="my.do">
		이름: <input type="text" name="username">
		
		<%-- err키값으로 저장되어 있는 메시지가 있다면
				id는 메시지를 저장할 변수 --%>
		<html:messages property="err" id="msg" >
			<font color="red"><bean:write name="msg"/></font>
		</html:messages>
		<br>
		나이: <input type="text" name="userage">
		<input type="submit" value="전송">
	</form>
</body>
</html>