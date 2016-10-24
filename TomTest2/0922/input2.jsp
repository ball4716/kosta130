<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- input2.jsp -->
<body>
	<h3>입력페이지</h3>
	<hr>
	<form action='result2.jsp' method='post'>
		이름: <input type='text' name='name'><br>
		비밀번호: <input type='password' name='pass'><br>
		히든: <input type='hidden' name='hdata' value='나히든'><br>
		좋아하는 과일:
			<input type="checkbox" name="fruit" value="사과"> 사과
			<input type="checkbox" name="fruit" value="딸기"> 딸기
			<input type="checkbox" name="fruit" value="바나나"> 바나나
			<br>
		강의실:
			<% for(int i=1; i<7; i++){ %>
				<input type="radio" name="room" value="<%= i%>강의실"> <%= i%>강의실
			<%} %>
			<br>
		저녁식사:
			<select name='dinner'>
				<option value="한식">한식</option>
				<option value="중식">중식</option>
				<option value="일식">일식</option>
			</select>
			<br>
		코멘트:<textarea rows="5" cols="20" name="comment"></textarea>
			<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>