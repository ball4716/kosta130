<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- selProduct.jsp(상품선택) --%>
<body>
	<%!
		String productNames[] = {"사과","바나나","딸기","복숭아","배","메론"};
	%>
	<% request.setCharacterEncoding("UTF-8");
	
		String username = (String)session.getAttribute("loginName");
		
		if(username==null){//setAttribute 전에 getAttribute를 했다면
							//[loginName]키에 저장된 데이터가 없다면
			username = request.getParameter("username");			
			session.setAttribute("loginName", username);
		}
		
	%>
	<center>
		<h3>상품선택</h3>
		<hr>
		<%= username%>님이 로그인한 상태입니다<br>
		<form action="add.jsp" method="post">
			<select name="product">
				<%
					for(int i=0; i<productNames.length; i++){
						out.print("");
					}
				%>
				<option>사과</option>
				<option>바나나</option>
				<option>딸기</option>
				<option>복숭아</option>
				<option>배</option>
				<option>메론</option>
			</select>
			<input type="submit" value="추가">
		</form>
		<br>
		<a href="checkOut2.jsp">계산</a>
	</center>
</body>
</html>