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
	<h3>입력폼(파일전송)</h3>
	<hr>
	<form action="result2.jsp" method="post" enctype="multipart/form-data">
		이름: <input type="text" name="name"> <br> 파일: <input
			type="file" name="myfile"> <br> <input type="submit"
			value="전송">
	</form>
	<hr>
	<h3>입력폼(cos.jar)</h3>
	<form action="result3.jsp" method="post" enctype="multipart/form-data">
		이름: <input type="text" name="name"> <br> 파일: <input
			type="file" name="myfile"> <br> <input type="submit"
			value="전송">
	</form>
</body>
</html>

