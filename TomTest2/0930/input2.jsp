<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>Insert title here</title>
</head>
<%-- input2.jsp --%>
<body>
	<h3>�Է���(��������)</h3>
	<hr>
	<form action="result2.jsp" method="post" enctype="multipart/form-data">
		�̸�: <input type="text" name="name"> <br> ����: <input
			type="file" name="myfile"> <br> <input type="submit"
			value="����">
	</form>
	<hr>
	<h3>�Է���(cos.jar)</h3>
	<form action="result3.jsp" method="post" enctype="multipart/form-data">
		�̸�: <input type="text" name="name"> <br> ����: <input
			type="file" name="myfile"> <br> <input type="submit"
			value="����">
	</form>
</body>
</html>

