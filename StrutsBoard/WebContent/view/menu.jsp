<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

	<ul>
		<li><a href="main.do">첫화면</a>
		<li><a href="/StrutsBoard/guest/main.do">첫화면</a>
		<li><html:link action="/guest/menu1">메뉴1</html:link>
		<li><html:link action="/guest/menu2">메뉴2</html:link>
		<li><html:link action="/guest/control?action=list">방명록</html:link>
	</ul>