<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- suggest.jsp(제시어를출력) --%>
<%
	String keywords[] = { "자바", "자동차", "자바라", "자바조", "자바서버페이지", "자라", "자연", "java", "junghoon", "jsp", "json",
			"jQuery", "ajax", "apple", "application", "area", "abcMart", "apt", "auto", "AOA" };
	//클라이언트가 입력한 데이터를 얻어오기
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");

	List<String> list = new ArrayList<>();

	//keyword로 시작하는 문자열을 출력
	//예) String str="ajaxProgramming"; str.startsWith("aj") ---> true
	if (keyword != null) {
		for (int i = 0; i < keywords.length; i++) {
			if (keywords[i].startsWith(keyword)) {
				list.add(keywords[i]);
			}
		}
	}
	out.print(list.size()+"|");
	for (int i = 0; i < list.size(); i++) {//List에 담긴 제시어 출력
		out.print(list.get(i));
		if(i<list.size()-1) out.print(",");
	}
%>