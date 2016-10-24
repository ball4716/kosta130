<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- add.jsp(상품 추가 처리) --%>
<body>
<%
	request.setCharacterEncoding("UTF-8");//post한글처리
	
	String product = request.getParameter("product");
	
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
	//ArrayList==과일바구니
			
	if(list==null){//바구니가 아직 생성되지 않았다면!!
		list = new ArrayList<>();
	}
	list.add(product);
	
	session.setAttribute("list", list);
%>
	<script type="text/javascript">
		alert('<%= product %>(이)가 추가되었습니다!!');
		history.back();//go(-1)
	</script>
</body>
</html>