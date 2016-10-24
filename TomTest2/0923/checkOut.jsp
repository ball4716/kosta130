<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- checkOut.jsp --%>
<body>
	<center>
		<h3>장바구니 목록</h3>
		<hr>
		<%
			//add.jsp ===> session.setAttribute("list", list);
			//add.jsp에서 세션 저장된 값을 얻어오기 ===> session.getAttribute("list");
			ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
			
			int cost = 0;
			if(list!=null){
				for(int i=0;i<list.size();i++){
					out.print(list.get(i));
					if(list.get(i).equals("사과")){
						cost+=1000;
						out.print(" : 1000원");
					}else if(list.get(i).equals("바나나")){
						cost+=2000;
						out.print(" : 2000원");
					}else if(list.get(i).equals("딸기")){
						cost+=3000;
						out.print(" : 3000원");
					}else if(list.get(i).equals("복숭아")){
						cost+=4000;
						out.print(" : 4000원");
					}else if(list.get(i).equals("배")){
						cost+=5000;
						out.print(" : 5000원");
					}else if(list.get(i).equals("메론")){
						cost+=6000;
						out.print(" : 6000원");
					}
					out.print("<br>");
				}
			}
		%>
		<hr>
		총금액: <%= cost%>원
	</center>
</body>
</html>