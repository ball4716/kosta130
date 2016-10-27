<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
  <c:when test="${state==null }">
    <font color="red">${result}</font>
  </c:when>
  <c:otherwise>
     <font color="blue">${result}</font>
  </c:otherwise>
</c:choose>    
