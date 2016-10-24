<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- emp.jsp(이름 얻어오기) --%>
<employee>
	<c:forEach items="${list }" var="v">
	<emp>
		<empno>${v.empno }</empno>
		<ename>${v.ename }</ename>
		<sal>${v.sal }</sal>
	</emp>
	</c:forEach>
</employee>