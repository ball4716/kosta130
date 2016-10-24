<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계산기폼</title>
</head>
<%-- calc_form.jsp --%>
<body>
	<center>
		<h3>계산기 폼</h3>
		<hr>
		<form action="calc.do" method="post">
			<input type="text" name="su1" size="4">
			<select name="oper">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			<input type="text" name="su2" size="4">
			<input type="submit" value="계산">
		</form>
		<%-- is_not_num_error=숫자만 입력 가능합니다
			by_zero_error=0으로 나눌 수 없습니다
			is_empty_error=공백은 계산할 수 없습니다 --%>
		<html:messages id="err_msg" property="is_not_num_error">
			<hr>
			<font color="red"><bean:write name="err_msg"/></font><br>
		</html:messages>
		<html:messages id="err_msg" property="is_empty_error">
			<hr>
			<font color="blue"><bean:write name="err_msg"/></font><br>
		</html:messages>
		<html:messages id="err_msg" property="by_zero_error">
			<hr>
			<font color="green">${err_msg }</font><br>
		</html:messages>
		<logic:present scope="request" name="result" >
			<hr>
			<font color="pink">
			${result }
			</font><br>
		</logic:present>
	</center>
</body>
</html>