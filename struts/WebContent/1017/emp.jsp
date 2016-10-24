<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- emp.jsp(이름 얻어오기) --%>
${cnt }|<c:forEach items="${list }" var="v" varStatus="stat">
			${v }<c:if test="${stat.count < cnt }">,</c:if>
		</c:forEach>